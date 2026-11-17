## Levantamento de Requisitos

### Requisitos Funcionais (RF)
- **RF01 – Cadastro de Livros:** O sistema deve permitir ao Bibliotecário cadastrar livros no acervo informando título, autor e ISBN.
- **RF02 – Cadastro de Exemplares:** O sistema deve permitir ao Bibliotecário vincular exemplares físicos a um livro existente, registrando código de patrimônio e estado de conservação.
- **RF03 – Cadastro de Membros:** O sistema deve permitir ao Bibliotecário cadastrar membros informando nome, matrícula e tipo (aluno, professor ou funcionário).
- **RF04 – Consulta ao Acervo:** O sistema deve permitir que Membros e Bibliotecários consultem livros e a disponibilidade de seus exemplares físicos.
- **RF05 – Registro de Empréstimo:** O sistema deve permitir registrar a retirada de um exemplar disponível por um membro ativo, definindo a data de retirada e calculando automaticamente o prazo de devolução.
- **RF06 – Registro de Devolução:** O sistema deve permitir registrar a devolução de um exemplar emprestado, atualizando sua disponibilidade no acervo e verificando eventuais atrasos.
- **RF07 – Cálculo e Aplicação de Multa:** O sistema deve calcular automaticamente o valor da multa por atraso com base nos dias corridos excedentes ao prazo de devolução e permitir que o Bibliotecário registre a aplicação/quitação.
- **RF08 – Solicitação de Reserva:** O sistema deve permitir que um Membro solicite a reserva de um exemplar que esteja emprestado no momento, registrando a data da solicitação.

### Regras de Negócio (RN)
- **RN01 – Prazo Padrão de Empréstimo:** O prazo padrão para devolução de qualquer exemplar emprestado é de 14 dias corridos a contar da data de retirada.
- **RN02 – Limite de Empréstimos Simultâneos:** Um membro não pode possuir mais de 3 empréstimos ativos simultaneamente.
- **RN03 – Condição de Reserva:** Um exemplar só pode ser reservado se já estiver emprestado no momento da solicitação.
- **RN04 – Cobrança de Multa por Atraso:** A multa por atraso é cobrada por dia corrido após o vencimento do prazo de 14 dias.

### Requisitos Não Funcionais (RNF)
- **RNF01 – Linguagem e Plataforma:** O sistema deve ser desenvolvido na trilha Java utilizando o JDK 21 (LTS).
- **RNF02 – Arquitetura Evolutiva:** O sistema deve operar como um programa standalone de console sem estruturas orientadas a objetos, evoluindo nas etapas seguintes para aplicação orientada a objetos e serviço web com API REST (Spring Boot), persistência em banco de dados e autenticação.
- **RNF03 – Usabilidade (Console):** A interface inicial via linha de comando (CLI) deve apresentar menus numéricos claros e mensagens de feedback imediatas para bloqueios de regras de negócio ou validações de entrada.
- **RNF04 – Integridade das Regras:** O sistema deve validar as pré-condições de empréstimo, devolução e reserva antes de alterar o estado de disponibilidade de qualquer exemplar.