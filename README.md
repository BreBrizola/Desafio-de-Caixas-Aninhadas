# Desafio de Caixas Aninhadas

## Introdução
O trabalho proposto consiste em implementar um pequeno desafio que envolve "sacanear a sogra" com um presente e embrulho criativo. Essa atividade visa estimular o raciocínio lógico dos estudantes e aplicar alguns conceitos trabalhados em sala de aula, promovendo também o desenvolvimento de habilidades de análise, síntese e trabalho em equipe.

## Problema
O desafio consiste em encontrar a maior sequência de caixas que podem ser colocadas uma dentro da outra, dado um catálogo com as dimensões de diferentes caixas. Cada caixa possui três dimensões: comprimento, largura e altura, mas as dimensões não estão identificadas ou ordenadas. Portanto, é necessário determinar qual a maior subsequência de caixas possível que pode ser agrupada, onde uma caixa pode ser encaixada dentro da outra apenas se todas as suas dimensões forem menores do que as da outra caixa.

## Processo de Solução
O trabalho foi desenvolvido em Java, a linguagem padrão utilizada em sala de aula. Para resolver o problema, foram desenvolvidas operações para leitura de texto, construção de um grafo e busca em profundidade, que são elementos trabalhados em aula.

Para construir o grafo, foi criado o método `construirGrafo`, que constrói um grafo direcionado, onde cada caixa é representada como um nó. Existe uma aresta do nó 'i' para cada nó 'j' se 'i' couber dentro de 'j'. Para isso, utilizou-se uma lista de adjacência, um array para armazenar os resultados da busca e outro array para armazenar os nós pais no caminho.

O método `dfs` realiza a busca em profundidade para encontrar o caminho mais longo dentro do grafo.

O grafo de caixas é construído pelo trecho de código abaixo. Ele encontra a maior sequência de caixas aninhadas usando DFS e imprime tanto o comprimento da sequência quanto a sequência em si. Após chamar o método `construirGrafo()` e inicializar as variáveis `maxLength` e `startIndex`, o código itera sobre as caixas e executa o método DFS. Ao final, uma lista com a sequência mais longa de caixas é criada, iniciando em `startIndex` e seguindo para os pais, invertendo a lista para obter a sequência do menor para o maior.

Na classe `Caixa`, foram implementados os métodos `compareTo` e `canFitInside`. O método `compareTo` compara duas caixas com base em suas dimensões (comprimento, largura e altura), permitindo a ordenação de uma lista de caixas. Ele verifica se as duas caixas não são iguais e faz a comparação com as larguras e alturas, retornando valores apropriados para permitir a ordenação.

O método `canFitInside` verifica se a caixa atual cabe dentro de outra. Para que a resposta seja positiva (true), todas as dimensões devem ser menores que as dimensões da outra caixa; caso contrário, retorna false.

## Conclusão
O programa lê um arquivo que contém as dimensões das caixas, cria objetos `Caixa` a partir das dimensões, constrói um grafo direcionado baseado na capacidade de uma caixa caber dentro da outra e usa DFS para buscar o caminho mais longo dentro do grafo, apresentando a sequência de caixas aninhadas.

Durante o desenvolvimento, algumas dificuldades foram enfrentadas. Inicialmente, a compreensão do que estava sendo pedido foi um desafio, dificultando a definição da estrutura a ser usada no programa. Essa falta de clareza resultou em atrasos e acúmulo de atividades. Também lidamos com erros que surgiram durante o processo, o que gerou alguns transtornos e atrasos na conclusão do trabalho, mesmo que a estrutura escolhida tenha sido a mesma trabalhada em aula.
