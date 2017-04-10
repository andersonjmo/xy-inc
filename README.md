# xy-inc

O projeto não foi concluído, mas a base do mesmo está estruturada e pronta. A Solução proposta utiliza DOM (Dynamic Object Model) para criação dos objetos dinamicos.

Antes de iniciar os testes, deve-se realizar a criação das tabelas iniciais, para isso, Na primeira execução alterar o persistence.xml descomentando o trecho abaixo, e alterando os dados de conexão, para que a aplicação possa criar o banco para persistencia. A Aplicação foi desenvolvida utilizando o banco postgres, para compatibilidade dos tipos é necessário manter o mesmo.

<property name="javax.persistence.schema-generation.database.action"
				value="drop-and-create" />
        

Na segunda execução, Comentar o Trecho acima, para que as tabelas não sejam deletadas no momento de execução, logo após comentar o property no persistence.xml, deve-se utilizar a execução dos testes JUNIT, classe teste.TesteCreateObject esta classe Cria uma Classe Dinamica Pessoa com os atributos (id,nome,sexo,salario), realiza a criação da tabela para persitencia dinamicamente, instancia o objeto e realiza o preenchimento dos dados, e também realiza a persistencia no banco.

O segundo cenário classe teste.TestePersisteObjectRest realiza o mesmo pocedimento da classe acima, mas realiza a persistencia utilizando rest,deve-se realizar a execução do projeto em um servidor de aplicação para expor os serviços rest e consumir utilizando a classe teste.TestePersisteObjectRest, este trecho não consegui concluir o desenvolvimento no prazo, o mesmo foi enviado sem conclusão.

