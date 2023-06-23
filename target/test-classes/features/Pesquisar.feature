#Author: lgomesfasantos@gmail.com

@Pesquisas
Feature: Realizar pesquisas

 Eu como usuario do google
  quero digitar no campo seach o titulo nttdata
  para acessar o primeiro link apresentado na pesquisa

  @CT-01
  Scenario: Realizar uma pesquisa Com palavra ntt data 
    Given que estou no site google
    When digito a palavra nttdata
    And clico em pesquisar
    Then posso acessar o primeiro link apresentado na pesquisa
    
    @CT-02
  Scenario: Realizar uma pesquisa para vaga de arquiteto no site da NTT 
    Given que estou no site da ntt
    And clico em carreira
    When acesso junte-se a nossa equipe
    Then na lista de vagas posso  pesquisar a vaga de arquiteto
    

  