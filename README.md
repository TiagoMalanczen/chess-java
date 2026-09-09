#  Chess System - Engine de Xadrez Orientada a Objetos

Motor lógico de xadrez desenvolvido em **Java puro**, implementado com separação estrita de camadas, manipulação matricial e validação defensiva de estados de jogo via interface de linha de comando (CLI).

---

<p align="center">
  <img src="imagens/Animação.gif" alt="Demonstração da partida de xadrez no terminal" width="500px">
  <br>
  <i>Interface CLI interativa com renderização de cores ANSI e destaque de movimentos válidos.</i>
</p>

---

##  Destaques do Projeto

- **Lógica e Regras Oficiais:** Implementação completa da movimentação das 6 peças do xadrez e validação de movimentos possíveis em matriz $8 \times 8$.
- **Detecção de Estados Críticos:** Algoritmos determinísticos para cálculo e detecção automática de **Xeque** e **Xeque-mate**.
- **Movimentos Especiais da FIDE:** Suporte integral a **Roque** (Pequeno e Grande), **En Passant** e **Promoção de Peão**.
- **Programação Defensiva:** Controle estrito do estado do tabuleiro via exceções customizadas (`BoardException`, `ChessException`), impedindo posições ilegais e violações de limites de matriz.
- **Interface Visual no Console:** Renderização com caracteres Unicode e escape codes ANSI para cores e realce dinâmico de casas alcançáveis.

---

##  Arquitetura e Engenharia de Software

O projeto adota uma arquitetura em camadas orientada a baixo acoplamento:

```text
src/
├── boardgame/     # Camada de infraestrutura genérica de tabuleiro e posicionamento de peças
├── chess/         # Camada de domínio: regras oficiais de xadrez, peças e partidas
│   └── pieces/    # Especializações das peças (Torre, Bispo, Cavalo, Rainha, Rei, Peão)
└── application/   # Camada de apresentação: I/O de console, parsing de coordenadas e UI

```
### Princípios Técnicos Aplicados

- **Polimorfismo e Classes Abstratas:** A classe abstrata base `Piece` dita o contrato de movimentação (`possibleMoves()`), enquanto cada peça implementa sua lógica matricial específica.
- **Encapsulamento Rígido:** Estado do tabuleiro e referências de memória internos protegidos, garantindo que mutações ocorram exclusivamente por métodos autorizados de partida.
- **Otimização Matricial:** Aplicação de vetores de deslocamento (*offsets*) para cálculo eficiente de alcance vetorial em peças com saltos ou passos unitários (Rei e Cavalo).

---

##  Tecnologias

- **Linguagem:** Java (JDK 17+)
- **Interface:** Terminal / CLI (com suporte a cores ANSI e codificação UTF-8)
- **Dependências:** Nenhuma (Construído utilizando exclusivamente a biblioteca nativa da JVM)

---

##  Como Executar

### Pré-requisitos
- JDK 17+ instalada e configurada no `PATH`.
- Terminal com suporte a UTF-8 e cores ANSI (Git Bash, Windows Terminal, terminal integrado da IDE ou shell Linux/macOS).

### Passo a Passo

1. **Clone o repositório:**
```bash
git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)
cd nome-do-repositorio
```
Compile as fontes do projeto:
```
Bash
javac -d bin src/boardgame/*.java src/chess/*.java src/chess/pieces/*.java src/application/*.java
```
Execute a aplicação (garantindo codificação UTF-8):
```
Bash
java -Dfile.encoding=UTF-8 -cp bin application.Program
