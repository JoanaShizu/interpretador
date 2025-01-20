using System;
using System.Collections.Generic;

namespace InterpretadorLang
{
    // Classe base para todas as variáveis
    public abstract class Variavel
    {
        public string Tipo { get; protected set; } // Tipo da variável (int, float, char, etc.)
        public object Valor { get; set; } // Valor armazenado na variável

        protected Variavel(string tipo, object valor = null)
        {
            Tipo = tipo;
            Valor = valor;
        }
    }

    // Classe para variáveis simples (int, float, char, etc.)
    public class VariavelSimples : Variavel
    {
        public VariavelSimples(string tipo, object valor = null) : base(tipo, valor) { }
    }

    // Classe para ponteiros
    public class Ponteiro : Variavel
    {
        public Variavel Referencia { get; private set; } // Referência à variável apontada pelo ponteiro

        public Ponteiro(string tipo) : base(tipo) { }

        public void AtribuirReferencia(Variavel referencia)
        {
            if (referencia.Tipo != Tipo)
            {
                throw new Exception($"Erro: Ponteiro do tipo '{Tipo}' não pode referenciar variável do tipo '{referencia.Tipo}'.");
            }

            Referencia = referencia;
        }

        public void ModificarValorApontado(object valor)
        {
            if (Referencia == null)
            {
                throw new Exception("Erro: Ponteiro não inicializado.");
            }

            Referencia.Valor = valor;
        }
    }

    // Classe que representa um escopo (global ou local)
    public class Escopo
    {
        private readonly Dictionary<string, Variavel> tabelaSimbolos = new Dictionary<string, Variavel>();
        private readonly Escopo escopoPai; // Escopo superior (para suporte a escopos aninhados)

        public Escopo(Escopo escopoPai = null)
        {
            this.escopoPai = escopoPai;
        }

        // Adiciona uma variável ao escopo atual
        public void AdicionarVariavel(string nome, Variavel variavel)
        {
            if (tabelaSimbolos.ContainsKey(nome))
            {
                throw new Exception($"Erro: A variável '{nome}' já foi declarada neste escopo.");
            }

            tabelaSimbolos[nome] = variavel;
        }

        // Obtém uma variável do escopo atual ou do escopo pai
        public Variavel ObterVariavel(string nome)
        {
            if (tabelaSimbolos.TryGetValue(nome, out Variavel variavel))
            {
                return variavel;
            }

            if (escopoPai != null)
            {
                return escopoPai.ObterVariavel(nome);
            }

            throw new Exception($"Erro: A variável '{nome}' não foi declarada.");
        }

        // Atualiza o valor de uma variável existente
        public void AtualizarVariavel(string nome, object valor)
        {
            if (tabelaSimbolos.ContainsKey(nome))
            {
                tabelaSimbolos[nome].Valor = valor;
            }
            else if (escopoPai != null)
            {
                escopoPai.AtualizarVariavel(nome, valor);
            }
            else
            {
                throw new Exception($"Erro: A variável '{nome}' não foi encontrada para atualização.");
            }
        }
    }

    // Gerenciador de escopos para lidar com escopos globais e locais
    public class GerenciadorEscopos
    {
        private readonly Stack<Escopo> pilhaEscopos = new Stack<Escopo>();

        public GerenciadorEscopos()
        {
            pilhaEscopos.Push(new Escopo()); // Cria o escopo global
        }

        // Retorna o escopo atual (no topo da pilha)
        public Escopo escopoAtual()
        {
            return pilhaEscopos.Peek();
        }

        // Cria um novo escopo e adiciona à pilha
        public void CriarNovoEscopo()
        {
            pilhaEscopos.Push(new Escopo(escopoAtual()));
        }

        // Remove o escopo atual da pilha
        public void RemoverEscopoAtual()
        {
            if (pilhaEscopos.Count > 1)
            {
                pilhaEscopos.Pop();
            }
            else
            {
                throw new Exception("Erro: Tentativa de remover o escopo global.");
            }
        }
    }
}
