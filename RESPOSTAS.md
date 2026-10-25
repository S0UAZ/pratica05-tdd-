# Respostas da reflexão - Prática 05 (TDD em Java)

## 1. No Ciclo 1 usamos `return 70`. Por que isso é aceitável no TDD? O que obrigou a escrever a soma de verdade?

É aceitável porque, no TDD, o objetivo da fase verde é escrever o mínimo de código para o teste passar (técnica "fingir até conseguir"). Com um único teste (20 + 20 + 30 = 70), retornar 70 já fazia ele passar, mas isso não prova que a soma funciona. O que obrigou a escrever a soma de verdade foi o segundo teste, com outros valores (10 + 15 + 25 = 50): o `return 70` falhou nele, e a única forma de passar nos dois foi implementar `a1 + a2 + a3`. Isso se chama triangulação.

## 2. No Ciclo 3, por que testar com 69 e 70, e não com 50 e 90?

Porque o erro mais provável é trocar `>=` por `>`. Com 50 ou 90, os dois operadores dão o mesmo resultado, então o erro passaria despercebido. Só testando exatamente na fronteira (70 aprova, 69 reprova) o teste consegue pegar esse erro. Isso é análise de valor limite.

## 3. No Ciclo 4, o que mudou na refatoração? Como você teve certeza de que não quebrou nada?

Os três `if` parecidos que validavam A1, A2 e A3 foram substituídos por um único método `validarNota(nota, notaMaxima, nomeAvaliacao)`, chamado três vezes. O comportamento continuou o mesmo, só o código ficou menos repetido e mais fácil de manter. Tive certeza de que não quebrei nada porque rodei todos os testes depois da mudança e todos continuaram verdes (9 de 9).

## 4. No Ciclo 8, por que alteramos os testes antes de mudar o código?

Porque no TDD os testes são a especificação do sistema. Quando o requisito muda, primeiro os testes passam a descrever a regra nova (e falham, porque o código ainda faz a regra antiga), e só depois o código é alterado até eles passarem. Assim eu sei que a regra nova está correta quando fica verde, e os testes antigos que não mudaram continuam protegendo o resto do comportamento.

## 5. Qual ciclo foi o mais difícil para você, e por quê?

Creio que a parte mais dificil foi conseguir entender toda a logica por tras dos testes.