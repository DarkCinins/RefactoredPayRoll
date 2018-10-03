# RefactoredPayRoll
Refatoramento do projeto Folha de Pagamento utilizando 3 padrões de projeto: Decorator, State e Builder.

Decorator foi utilizado nas classes de empregados, permitindo uma melhor organização e facilitando futuras alterações.
State foi utilizado para definir o método de pagamento de cada funcionário (que antes era feito com enum).
Builder foi utilizado na construção do objeto "Addresses" (que antes era construído e editado dentro dele mesmo, e agora é somente editado).

O código com smells para comparação pode ser encontrado em: https://github.com/DarkCinins/PayRoll
