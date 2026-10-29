# Arena dos Campeões

Arena dos Campeões é um RPG de turnos executado no terminal. O jogador escolhe um nome e uma classe, depois enfrenta três inimigos em sequência. A partida termina quando o jogador perde toda a vida ou derrota os três oponentes.

## Requisitos

- JDK 25 ou superior para compilar diretamente com `javac`.

## Compilar e executar

Execute os comandos a partir da raiz do módulo (`Modulo 4`).

### Com `javac` em Bash

```bash
mkdir -p target/classes
javac -d target/classes $(find src/main/java -name '*.java')
java -cp target/classes desafio.Jogo
```

## Regras do jogo

- O jogador escolhe Guerreiro, Mago ou Arqueiro em um menu com descrição de cada classe; cada classe aplica um bônus próprio de vida, ataque ou defesa.
- Cada partida tem três inimigos com nomes e atributos aleatórios.
- A cada turno, o jogador pode atacar, defender ou usar uma poção de cura.
- O inimigo ataca em 75% dos turnos e defende em 25% deles.
- Defender reduz pela metade o próximo dano recebido.
- O jogador começa com três poções. Cada uma recupera até 20 pontos de vida e é consumida apenas quando recupera vida.
- A vida e as poções restantes são mantidas entre as batalhas.
- Cada inimigo derrotado vale 10 pontos.
- Cada vitória também concede 10 moedas. Entre as batalhas, a loja permite gastar 10 moedas para aumentar o ataque em 2 ou a vida máxima em 15; a melhoria de vida também recupera 15 pontos.
- O ranking associa nomes e pontuações usando `Map<String, Integer>`. Partidas com o mesmo nome acumulam pontos; o ranking permanece disponível enquanto o programa estiver aberto.
- Ao terminar uma partida, o jogador pode iniciar outra ou encerrar o programa.
- Entradas numéricas, opções disponíveis e nome do jogador são validados.

## Estrutura do pacote

| Classe | Responsabilidade |
|---|---|
| `Jogo` | Inicia partidas, controla as batalhas e mantém a pontuação e o ranking da sessão. |
| `Batalha` | Conduz os turnos, apresenta o status e processa as ações. |
| `Personagem` | Define atributos, ataque, defesa, dano, vida e poções. |
| `Loja` | Permite comprar uma melhoria de ataque ou vida máxima entre as batalhas. |
| `Guerreiro`, `Mago`, `Arqueiro` | Aplicam os bônus das classes jogáveis. |
| `Inimigo` | Gera nome e atributos aleatórios e define a escolha de defesa da IA. |
| `CriadorPersonagem` | Lê as escolhas do jogador e cria os personagens. |
| `Inventario` | Armazena e conta os itens. |
| `Input` | Centraliza a leitura e validação básica das entradas do terminal. |

O código-fonte desta aplicação fica neste pacote. Os demais pacotes em `src/main/java` contêm estudos e exercícios do Módulo 4.
