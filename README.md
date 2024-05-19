# Projeto-MC322

### Grupo: 

Antonio Carlos Carvalho Macedo - 199152

Iran Seixas Lopes Neto - 244827

Rafael Campideli Hoyos - 175100

OBS.: Utilizamos o liveshare do vs code para desenvolver o projeto, por isso a maioria dos commits são apenas de uma pessoa, porém todos contribuiram para o projeto de maneira uniforme.

## Resumo:

O projeto visa desenvolver um sistema de cardápio virtual para restaurantes, que pode ser aplicado a um totem de uma lanchonete, por exemplo. Através desse sistema, o cliente deve ser capaz de se identificar, ver o menu, adicionar produtos ao carrinho, personalizar os produtos, editar o carrinho, fechar o pedido  e realizar o pagamento.
O sistema deve implementar uma base de dados com o menu do restaurante: as opções de hamburguer, de bebida, combos e sobremesas.

## Funcionamento do programa passo a passo1:
No projeto 1, aplicação de console:

- Identificação do cliente (nome e cpf)
- Menu de seleção dos produtos. Print do cardápio, estado do carrinho e comandos em loop:
    - [A x] = adicionar produto x
        - Na adição, pode aparecer um menu de escolha de opções do produto (ex. tamnho da batata)
    - [R x] = remover produto x
    - [C ] = concluir
- Pergunta se pedido é para viagem
- Forma de Pagamento? Pix, cartão(crédito/débito), ticket refeição
- Simulação do pagamento e envio do pedido para a cozinha
  
## Diagrama de Classes do Projeto:
![Diagrama de Classes do Projeto](https://github.com/TochaFh/Projeto-MC322/assets/131920201/d8aa9abe-72f8-4a48-ad8d-d02a34793f3a)

## Teste do programa:
```
--- Hamburgueria Daboa ---
Bem vindo(a)!
Informe seu nome:
Bob Marley
Informe seu cpf:
oi :D
Cpf inválido, digite novamente:
119.141.320-92
-------------
CARD?PIO:
1 - Double bacon spicy - R$ 20,00
2 - Big Columbini - R$ 30,00
3 - Double Australian - R$ 28,00
4 - Combo Australiano - Double Australian; Batata; Bebida;  - R$ 23,80
5 - Combo Colombini - Big Columbini; Batata; Bebida;  - R$ 25,50      
6 - Batata + bebida em dobro - Batata; Batata; Bebida; Bebida;        
7 - Brownie - R$ 8,00
8 - Batata
9 - Bebida
-------------
 - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);
A 3
Item adicionado!


===Carrinho===
1 - Double Australian - R$ 28,00

Total: R$ 28,00
 - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);
a 1
Item adicionado!


===Carrinho===
1 - Double Australian - R$ 28,00
2 - Double bacon spicy - R$ 20,00

Total: R$ 48,00
 - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);
R 1
Item removido! (Double Australian)


===Carrinho===
1 - Double bacon spicy - R$ 20,00

Total: R$ 20,00
 - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);
A 5
*OPÇ?ES DO COMBO
1. Big Columbini:
2. Batata:
Qual o tamanho da batata? (P) - Pequena, R$5,00; (M) - Media, R$10,00 (G) - Grande, R$15,00:
p
3. Bebida:
Qual o tamanho da bebida? (P) - Pequena, R$4,00; (M) - Media, R$8,00 (G) - Grande, R$12,00:
M
Qual o tipo da bebida?
1 - Coca-cola
2 - Coca-cola zero
3 - Guaraná
4 - Guaraná zero
5 - Sprite
6 - Suco de laranja
7 - Suco de uva
8 - Suco de lim?o
3
Item adicionado!


===Carrinho===
1 - Double bacon spicy - R$ 20,00
2 - Combo Colombini - Big Columbini; Batata pequena; Guaraná médio(a);  - R$ 36,55

Total: R$ 56,55
 - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);
A 7
Item adicionado!


===Carrinho===
1 - Double bacon spicy - R$ 20,00
2 - Combo Colombini - Big Columbini; Batata pequena; Guaraná médio(a);  - R$ 36,55
3 - Brownie - R$ 8,00

Total: R$ 64,55
 - Utilize os Comandos: A x (adicionar produto x) | R x (remover produto x do carrinho) | C (concluir carrinho);
C


===Carrinho===
1 - Double bacon spicy - R$ 20,00
2 - Combo Colombini - Big Columbini; Batata pequena; Guaraná médio(a);  - R$ 36,55
3 - Brownie - R$ 8,00

Total: R$ 64,55
 - O pedido é para viagem?(S/N):
N
 - Qual será a forma de pagamento? P (Pix) | D (Débito) | C (Crédito) | R (Refeiç?o)
D
Processando...
Pagamento realizado com sucesso!
===Pedido===
1 - Double bacon spicy - R$ 20,00
2 - Combo Colombini - Big Columbini; Batata pequena; Guaraná médio(a);  - R$ 36,55
3 - Brownie - R$ 8,00
Total: R$R$ 64,55
Pedido para comer aqui.
Cliente: Bob Marley.

Seu pedido foi enviado para cozinha, ele estará pronto em alguns instantes!
Obrigado pela preferência, Bob Marley!
```
