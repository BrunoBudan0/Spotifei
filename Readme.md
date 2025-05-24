🎧 Spotifei - Plataforma de Informações de Áudios Digitais
Projeto Java com Interface Gráfica, PostgreSQL e POO desenvolvido para a disciplina de Arquitetura de Software e Programação Orientada a Objetos (ASPOO) da FEI.

📌 Descrição
O Spotifei é uma aplicação desenvolvida em Java que simula uma plataforma de gerenciamento e consulta de informações sobre áudios digitais, como músicas e podcasts (sem reprodução de áudio). Com interface gráfica intuitiva, o sistema permite o cadastro, login de usuários e interação com músicas e playlists. Utiliza princípios de Programação Orientada a Objetos (POO) e o padrão MVC (Model-View-Controller), com persistência de dados via PostgreSQL.

⚙️ Funcionalidades Principais
🔐 Autenticação de Usuário
Login de usuários com nome e senha.

Cadastro de novos usuários, caso ainda não possuam conta.

🏠 Página Inicial (Home)
Acesso aos botões:

Pesquisa de músicas

Playlists

Músicas Curtidas

🔍 Pesquisa
Barra de pesquisa para localizar músicas.

Botões para:

Curtir músicas

Adicionar músicas a playlists

🎵 Playlists
Criar novas playlists.

Editar playlists existentes.

Excluir playlists.

❤️ Músicas Curtidas
Visualização das músicas curtidas.

Remoção de músicas da lista de curtidas.

🛠️ Estrutura do Código
MVC (Model - View - Controller): separação clara de responsabilidades.

Interface Gráfica: JFrame.

Banco de Dados: Integração com PostgreSQL para armazenamento persistente.

Pacotes organizados por domínio (ex: model, controller, view, dao).

💻 Tecnologias Utilizadas
Linguagem: Java

Banco de Dados: PostgreSQL

GUI: JFrame

Arquitetura: MVC (Model, View, Controller)

🧱 Estrutura do Projeto
/spotifei
├── /src
│   ├── /model          # Classes de domínio (Usuário, Música, Playlist)
│   ├── /view           # Telas e elementos gráficos
│   ├── /controller     # Lógica de navegação e controle
│   └── /dao            # Acesso ao banco de dados (JDBC + PostgreSQL)
├── /assets             
└── README.md
▶️ Como Executar
✅ Pré-requisitos
JDK instalado (Java 8 ou superior)

PostgreSQL instalado e configurado

IDE Java (ex: IntelliJ, Eclipse)

Driver JDBC do PostgreSQL adicionado ao projeto

🔧 Configuração
Clone o repositório:

bash
Copiar
Editar
git clone (https://github.com/BrunoBudan0/Spotifei.git)
cd spotifei
Configure o banco de dados:

Crie o banco e as tabelas conforme o script SQL fornecido no projeto (ex: script.sql).

Compile e execute o projeto na IDE de sua preferência.

🔒 Regras e Considerações
O login deve ser realizado com o nome de usuário e senha fornecidos no cadastro.

Todas as interações com músicas e playlists são persistidas no banco.

A interface gráfica foi projetada para simplicidade e usabilidade.

🚀 Possíveis Melhorias Futuras
Implementar sistema de reprodução de áudio.

Melhorar design da interface com bibliotecas gráficas mais modernas.

👨‍💻 Desenvolvedor
Feito com ❤️ por
Bruno Budano Mello
RA: 22.124.006-2
