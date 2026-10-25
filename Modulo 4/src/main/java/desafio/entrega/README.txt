ARENA DOS CAMPEÕES

Arena dos Campeões é um RPG de turnos executado no terminal. O jogador escolhe um nome e uma classe e enfrenta três inimigos em sequência. A partida termina quando o jogador perde toda a vida ou derrota os três oponentes.

REQUISITOS

- JDK 25 ou superior para compilar diretamente com javac.

COMPILAR E EXECUTAR

Execute os comandos a partir da raiz do módulo (Modulo 4).

Com javac em Bash:

    mkdir -p target/classes
    javac -d target/classes $(find src/main/java -name '*.java')
    java -cp target/classes desafio.Jogo

REGRAS DO JOGO

- O jogador escolhe Guerreiro, Mago ou Arqueiro; cada classe aplica um bônus próprio de vida, ataque ou defesa.
- Cada partida tem três inimigos com nomes e atributos aleatórios.
- A cada turno, o jogador pode atacar, defender ou usar uma poção de cura.
- O inimigo ataca em 75% dos turnos e defende em 25% deles.
- Defender reduz pela metade o próximo dano recebido.
- O jogador começa com três poções. Cada uma recupera até 20 pontos de vida e só é consumida quando recupera vida.
- A vida e as poções restantes são mantidas entre as batalhas.
- Entradas numéricas, opções disponíveis e nome do jogador são validados.

ESTRUTURA DO PACOTE

- Jogo: inicia a partida, controla as batalhas e determina o resultado final.
- Batalha: conduz os turnos, apresenta o status e processa as ações.
- Personagem: define atributos, ataque, defesa, dano, vida e poções.
- Guerreiro, Mago e Arqueiro: aplicam os bônus das classes jogáveis.
- Inimigo: gera nome e atributos aleatórios e define a escolha de defesa da IA.
- CriadorPersonagem: lê as escolhas do jogador e cria os personagens.
- Inventario: armazena e conta os itens.
- Input: centraliza a leitura e validação básica das entradas do terminal.

O código-fonte desta aplicação fica no pacote src/main/java/desafio. Os demais pacotes em src/main/java contêm estudos e exercícios do Módulo 4.
