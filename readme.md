# **PROJEKT TKOM**

**Autor**: Krzysztof Kluczyński 318672<br>
**Prowadząca**: Agnieszka Malanowska<br>
**Temat nr 8**: Język z wbudowanym typem słownika, którego zawartość można sortować.<br>

## **<br>Opis:**
Tematem projektu jest realizacja interpretera języka z wbudowanym typem słownika. 
Zawartość struktury można sortować, wykonując dedykowaną do tego metodę, przyjmującą wyrażenie w stylu _lambda_ jako parametr określający sposób sortowania.
Wykonanie tej metody powoduje zmianę kolejności iterowania po elementach struktury.
Możliwe są także wszystkie podstawowe operacje na słowniku: 
* Dodawania elementów
* Usuwanie elementów
* Modyfikowanie elementów 
* Wyszukiwanie elementów według klucza
* Sprawdzenie, czy klucz znajduje się w słowniku
* Iterowanie po słowniku

Język pozwala także na wykonywanie zapytań w stylu LINQ, 
umożliwiających wyszukiwanie, filtrowanie oraz przejrzyste zwrócenie danych w sposób określony przez użytkownika.
<br>
<br>
Do implementacji wykorzystano język Java 17.
Decyzja o wykorzystaniu tego języka została podjęta głównie ze względu na fakt,
że jest to jedna z nowszych wersji języka Java o długoterminowym wsparciu (LTS).
Korzystanie z LTS wersji Java zapewnia stabilność, bezpieczeństwo oraz długoterminowe wsparcie ze strony producenta.


### **<br>Cechy języka:**
* **Statyczne typowanie**, wszystkie typy danych muszą być jasno zadeklarowane zgodnie ze składnią języka
* **Silne typowanie**, automatyczne konwersje między typami nie są obsługiwane, takie operacje wymagają jasnego zdefiniowania za pomocą wbudowanych w język mechanizmów 
* **Argumenty**, argumenty są przekazywane przez wartość, co oznacza, że funkcje nie mogą zmieniać wartości przekazanych argumentów
* **Mutowalność**, zmienne są mutowalne
* **Funkcja main**, plik źródłowy musi zawierać jedną bezargumentową funkcję main zwracającą int
* **Zakres zmiennych**, zmienne są widoczne jedynie w bloku kodu między nawiasami klamrowymi {}, gdy zostały w nim zainicjowane lub przekazane jako parametr w przypadku funkcji.


## **<br>Instrukcja uruchomienia:**

Aby zbudować projekt, należy wykonać komendę:

```
mvn clean package
```

Aby uruchomić interpreter, konieczna jest zainstalowana Java 17. Uruchamiamy go przy użyciu wcześniej spakowanego pliku jar, za pomocą polecenia zawierającego jako argumenty ścieżki do pliku jar oraz pliku z naszym kodem:

```
java -jar <jar file path> <file path>

//Przykład
//java -jar .\target\TKOM_PROJECT-1.0-SNAPSHOT.jar .\test_examples\interpreterShowcaseFunctionCall.txt
```

Wynik działania naszego programu powinien wyświetlić się w konsoli wraz ze zwracaną przez funkcję main wartością.


## **<br>Najważniejsze konstrukcje językowe wraz z przykładami:**
* **Komentarze**
  * Komentarz jednoliniowy
    ```
    //This is comment
    ``` 

  * Komentarz jednoliniowy
  
    ```
    /*
    This is a multiline comment
    */
    ``` 

* **Typy danych:** 
    * `bool`: Reprezentuje wartości logiczne, które mogą być `true` lub `false`.
    * `int`: Reprezentuje liczby całkowite. Zakres możliwy do ustawienia jako parametr programu. 
    * `float`: Reprezentuje liczby zmiennoprzecinkowe pojedynczej precyzji. Zakres możliwy do ustawienia jako parametr programu.
    * `String`: Reprezentuje sekwencję znaków, która może zawierać litery, cyfry, białe znaki oraz znaki specjalne. Maksmalna długość łańcucha możliwa do ustawienia jako parametr programu.
  

  Zakresy oraz długość łańcucha posiadają domyślne wartości zdefiniowanie w analizatorze leksykalnym. Nie ma konieczności podawania ich jako argumenty wywołania programu, jednak jest to możliwe.

      ```
      bool var_bool = true;
      int var_int = 2;
      float var_float = 3.2;
      String a = "Hello";
      String b = "World";
      ```


* **Kolekcje:**
    * `List`: Kolekcja elementów uporządkowanych, która pozwala na przechowywanie wielu elementów o tym samym typie.
    Dostępne operacje:
      * `add` - pozwala na dodanie elementu do listy
      * `delete` - pozwala na usunięcie elementu z listy 
      * `get` - zwraca konkretny argument z listy, przyjmuje indeks jako parametr
      * `set` - zmiana konkretnej wartości w tablicy, pierwszy argument to indeks, drugi to wartość
        ```
        List<int> var_list = [1, 2, 3, 4, 5];
        
        var_list.add(12); //dodanie elementu na koniec listy
        var_list.delete(0); //usunięcie podanego elementu z listy, w tym przypadku liczby 2
        var_list.get(0); //uzyskanie pierwszego elementu z listy
        var_list.set(0, 2); //ustawienie wartości znajdującej się na pozycji o indeskie 0 na 2
        ```
    * `Tuple`: Krotka jest kolekcją dwóch elementów o różnych typach, które są traktowane jako pojedyncza jednostka.
    Dostępne operacje:
        * `get` - zwraca wartość, która znajduje się pod podanym jako parametr indeksem
        * `set` - zmiana konkretnej wartości w tablicy
    
         ```
         Tuple<String, int> var_tuple = ("dog", 3);
      
        var_tuple.get(0) //uzyskanie pierwszego elementu z listy
        var_tuple.set(0, 2) //ustawienie wartości znajdującej się na pozycji o indeskie 0 na 2
         ```
    * `Dictionary`: Kolekcja par klucz-wartość, gdzie każdy klucz musi być unikalny, a wartości mogą być dowolnego typu.
    Dostępne operacje:
        * `add` - dodanie elementu do słownika, przyjmuje dwa argumenty, klucz i wartość
        * `delete` - usuwa pare klucz-wartość ze słownika, argument to klucz z pary, która ma zostać usunięta
        * `get` - zwraca wartość dla podanego klucza
        * `set` - ustawia nową wartość dla podanego klucza, przyjmuje dwa argumenty, klucz i wartość
        * `ifexists` - sprawdzenie, czy klucz występuje w słowniku
        * `sort` - sortuje zawartość słownika według wskazanego przez użytkownika schematu
      
      ```
      Dictionary<String, int> var_dict = |
          "dog": 3,
          "cat": 4,
          "cow": 5,
          "hamster": 6 
      |;
      
      int a = var_dict.get("dog");
      bool b = var_dict.ifexists("hamster")
      var_dict.delete("hamster");
      var_dict.add("hamster", 6);
      var_dict.set("sheep", 7);
      
      // Przykłady sortowania - dokładne omówienie poniżej
      // Sortowanie po wartościach rosnąco
      var_dict.sort((Tuple<String, int> a,Tuple<String, int> b) => a.get(1) > b.get(1)); //jezeli wartość a jest wieksze od wartości b to a powinno być pierwsze w kolejności

      // Sortowanie po wartościach malejąco
      var_dict.sort((Tuple<String, int> a,Tuple<String, int> b) => a.get(1) < b.get(1)); //jezeli wartość a jest mniejsza od wartości b to to a powinno byc pierwsze

      // Sortowanie alfabetyczne kluczy 
      var_dict.sort((a, b) => ((Tuple<String, int> a,Tuple<String, int> b) => a.get(0) > b.get(0));); 
       
      ```
      Omówienie przykładowych sortowań
      1. Sortowanie po wartościach rosnąco:<br>
         sort((Tuple<String, int> a, Tuple<String, int> b) => a.get(1) > b.get(1));
         oznacza, że elementy zostaną posortowane w kolejności rosnącej na podstawie ich wartości.
         Ta lambda sortuje słownik w kolejności rosnącej według wartości. W każdej iteracji algorytmu porównuje wartości (int) dwóch kolejnych elementów (a i b). Jeśli wartość elementu a jest większa niż wartość elementu b, elementy są zamieniane miejscami. Proces jest powtarzany, aż cały słownik zostanie posortowany od elementu o najmniejszej wartości do największej.

      2. Sortowanie po wartościach malejąco:<br>
         sort((Tuple<String, int> a, Tuple<String, int> b) => a.get(1) < b.get(1));
         to odwrócona kolejność porównania. Tutaj wartości są porównywane w odwrotnej kolejności, co powoduje sortowanie malejące.
         W tym przypadku, lambda sortuje słownik w kolejności malejącej według wartości. Algorytm porównuje wartości dwóch elementów, i jeżeli wartość a jest mniejsza od wartości b, dokonuje zamiany ich miejscami. Celem jest uporządkowanie elementów od największej do najmniejszej wartości.

      3. Sortowanie alfabetyczne kluczy :<br>
         sort((Tuple<String, int> a, Tuple<String, int> b) => a.get(0) > (b.get(0));
         wykorzystuje funkcję compare do porównania kluczy. Ta funkcja lambda sortuje słownik alfabetycznie na podstawie kluczy. Taka składania jest możliwa dzięki możliwości porównywania stringów.
      <br>
        
    <br>
* **Operatory logiczne:**
  * `and` - operator koniunkcji
  * `or` - operator alternatywy
  * `not` - operator negacji
  
    Przykładowe operacje: 

    ```
    bool var_true = true;
    bool var_false = false;
    
    bool a = var_true and var_false; // a = False
    bool b = var_true or not var_false; // b = True
    ```

    <br>
* **Operatory arytmetyczne:**
    <br> Dostępne dla typów liczbowych, dodawanie również dla typu String.
  * `*`      - operator mnożenia
  * `/`      - operator dzielenia
  * `+`      - operator dodawania
  * `-`      - operator odejmowania
    ```
    int first = 4;
    int second = 3;
    int third = 2;
    
    // dzielenie dwóch zmiennych typu integer również zwraca integer, czyli po wykonaniu poniższej linii zmienna resultOne = 1
    int resultOne = second / third;  
    
    //zachowana jest kolejność działań zgodna z matematyką, czyli po wykonaniu poniższej linii zmienna resultTwo = 14
    int resultTwo = 2 + first * second;
    
    //możliwia jest operacja dodawania dla typu String
    String hello = "Hello " + "World";
    ```

    <br>
* **Operatory porównania:**
    * `==`: Oznacza równość, sprawdza, czy dwa elementy są równe.
    * `!=`: Oznacza nierówność, sprawdza, czy dwa elementy nie są równe.
    * `<`: Oznacza mniej niż, sprawdza, czy pierwszy element jest mniejszy niż drugi.
    * `<=`: Oznacza mniejsze bądź równe, sprawdza, czy pierwszy element jest mniejszy lub równy drugiemu.
    * `>`: Oznacza większe niż, sprawdza, czy pierwszy element jest większy niż drugi.
    * `>=`: Oznacza większe bądź równe, sprawdza, czy pierwszy element jest większy lub równy drugiemu.
  
      ```
      int a = 2;
      bool var = a < 1; 
      bool var1 = a != 2;
      bool var2 = a >= 2;
      
      //przyklady rowniez w sekcji nizej "intrukcje warunkowe"
      ```

    <br>
* **Instrukcje warunkowe:** 
    * `if`: Instrukcja warunkowa, która wykonuje określony blok kodu, jeśli warunek jest spełniony.
      ```
      int a = 3;
        
      if (a != 2) {
          a = a + 2;
      }
      ```
    * `if-else`: Instrukcja warunkowa, która wykonuje określony blok kodu, jeśli warunek jest spełniony, a inny blok kodu, jeśli warunek nie jest spełniony.
      ```
      int a = 2;
      int b;
      
      if (a >= 2) {
            b = 2;
      } else {
            b = 0;  
      }
      ```

    * `if-elif`: Instrukcja warunkowa, która wykonuje różne bloki kodu w zależności od spełnienia warunków.

      ```

      int a = 2;

      int b;

      
      if (a == 2) {

            b = 2;

      } elif (a < 2) {

            b = -3;  

      } else {
            b = 3;
      }

      ```


* **Pętle:**
    * `while`: Pętla, która wykonuje określony blok kodu, dopóki podany warunek jest spełniony.
      ```
      int x = 2;
    
      while (x != 5) {
          x = x + 1;
      }
      ```

    * `for`: Pętla, która pozwala iterować po listach oraz słownikach.
      ```
      List<int> list = [1, 2, 3, 4, 5, 6, 7, 8];
    
      int sum;
      for (int x : list) {  
          sum = sum + x;
      }
      
      Dictionary<String, int> var_dict = |
          "dog": 3,
          "cat": 4,
          "cow": 5,
          "hamster": 6 
      |;
      
          
      for (Tuple<String, int> i : var_dict) { 
          print(i.get(0));
      }
      ```

* **Funkcje:**
    <br>W języku, każda funkcja zaczyna się od słowa kluczowego `fn` (skrót od function), po którym następuje deklaracja typu zwracanego funkcji - jeśli funkcja nic nie zwraca, typ ten jest `void`. Każdy argument funkcji musi być również opisany przez swój typ. Ciało funkcji znajduje się w nawiasach klamrowych.
    <br>Zmienne przekazywane do funkcji są przekazywane przez wartość.
    <br>Nie ma możliwości przeciążania funkcji.
    <br>Aby program działał poprawnie, musi zawierać dokładnie jedną specjalnie zdefiniowaną funkcję, nazywaną `main`. Jest to funkcja, od której zaczyna się wykonywanie programu. W języku `main` może zwracać dowolną wartość.<br>

  * funkcja niezwracająca wartości

         ```
         //funkcja wypisująca na ekran czy podana liczba jest większa niż 0
         fn void printIfPositiveorNegative(int number) {
            if (number > 0) {
                print("The number is bigger than 0.");
            } else {
                print("The number is less than 0.");
            }
         }
      
      
         fn int main() {
            int x = 26;
            printIfPositiveorNegative(x);
    
            return 0;
         }
         ```

  * funkcja bezargumentowa
  
         ```
         //funkcja zwracająca maksymalną możliwą liczbę typu int oraz jej wywowłanie w funkcji main
         fn int getMaxInt() {
             return 2147483647;
         }
    
    
         fn int main() {
             int x = getmaxInt();
             print($String x)
             return 0;
         }
         ```
       
       
  * funkcja zwracająca sume z otrzymanej listy

         ```
         //funkcja wykonująca inkrementację dla przekazanego typu int
         fn int sum(List<int> list) {
             int sum;
              for (int x : list) {
                 sum = sum + x;
             }
                return sum;
         }


         fn int main() {
             int x;
             List<int> x = [1, 2, 3, 4, 5, 6, 7, 8];
             int y = sum(x);
             print($String y); 
             return 0;
         }
         ```
      
    

  * **Funkcje wbudowane:**
      * print
        <br>Funkcja print powoduje wypisanie tekstu w konsoli, przyjmuje jedynie argumenty typu String. 
        ```
        fn int main() {
            print("Hello");
            return 0;
        }
        ```

      <br>
  * **Operatory rzutowania:**
      <br> Z racji tego, że język jest statycznie typowany, zostały utworzone mechanizmy rzutowania. Aby rzutować zmienną na inny typ, musimy użyć `$` oraz nazwy typu, na jaki rzutujemy.<br>
      W przypadku rzutowania `float` na `int` cyfry po przecinku są ucinane. 

      * int na float: rzutowanie bezstratne
        ```
        fn int main() {
            int x = 2;
            float y = $float x; // y = 2.0
            return 0;
        }
        ```
      * float na int: obcięcie cyfr po przecinku
        ```
        fn int main() {
            float x = 3.93;
            int y = $int x; // y = 3
            return 0;
        }
        ```
      * int na string
        ```
        fn int main() {
            int x = 3;
            String y = $String x;
            return 0;
        }
        ```
      * float na string
        ```
        fn int main() {
            float x = 3.2;
            String y = $String x;
            return 0;
        }
        ```
      * string na int
        ```
        fn int main() {
            String x = "3";
            int y = $String x;
            return 0;
        }
        ```
      * string na float
        ```
        fn int main() {
            String x = "3.2";
            float y = $float x;
            return 0;
        }
        ```

      <br>
  * **Zapytania na słownikach:** 
      * Możliwe jest wykonanie zapytania na strukturze słownika w sposób deklaratywny. Wynik może zostać przypisany do innej kolekcji
        ```
        Dictionary<String, int> var_dict = |
            "dog": 3,
            "cat": 4,
            "cow": 1,
            "hamster": 6
        |;
      
        Dict<String, int> query_result =    
                                  SELECT 
                              (var_dict.key, var_dict.value)
                                  FROM
                              var dict
                                  WHERE
                              (var_dict.value > 2)
                                  ORDER BY
                              var_dict.value
                                  ASC

        List<String> query_result2 = 
                                  SELECT 
                              (var_dict.key)
                                  FROM
                              var_dict
                                  WHERE
                              (var_dict.value != 3)
                                  ORDER BY
                              var_dict.value
                                  DESC
        ```

## **<br>Gramatyka:**
Poniżej opisana jest gramatyka naszego języka. Posiada ona kilka "skrótów" ułatwiających jej analizę i zrozumienie ( np. definicja character jako dowolnego znaku unicode czy pominięcie definicji spacji). Niestety takie ułatwienia uniemożliwiają testowanie jej za pomocą gotowych narzędzi.
Dlatego w głównym folderze projektu znajduje się też plik gramatic.txt,
który posiada jedynie kilka zmian względem tego co widać poniżej, m.in lepiej zdefiniowanie letter (wypisany cały alfabet zamiast [a-zA-Z]) oraz brak zdefiniowanego character. 
Pomaga to w testowaniu naszej gramatyki za pomocą narzędzi takich jak https://mdkrajnak.github.io/ebnftest/.
Niestety nie da się ominąć braku definicji znaków białych, przez co podczas testowania w polu "Test Input" należy umieszczać cały kod ciągiem.
```
 program                    = {function_definition}
 function_definition        = "fn",  (type | "void"), identifier, "(", parameters-list, ")", block;
 
 parameters-list            = [ type, identifier, { ",", type,  identifier } ]; 

 block                      = "{", { statement }, "}";
 
 statement                  = conditional
                            | while_loop
                            | for_loop
                            | declaration_or_definition
                            | function_call_or_assignment
                            | return_statement;
                            
                                                 
 conditional                = "if", "(", expression, ")", block,
                            [ { "elif", "(", expression, ")", block },  
                            "else", block ];
                                                                       
 while_loop                 = "while", "(", expression, ")", block;
 
 for_loop                   = "for", "(", type, identifier ":" ,identifier, ")", block;
 
 declaration_or_definition  = type, identifier, ["=", expression ], ";";
 
 query_statement            = "SELECT", select_clause, "FROM", identifier, [where_clause], [order_by_clause];
 
 select_clause              = "(", expression, { ",", expression }, ")";
 
 where_clause               = "WHERE", "(", expression, ")";

 order_by_clause            = "ORDER BY", expression, ("ASC" | "DESC");  
  
 function_call_or_assignment = identifier, (, "(", arguments-list, ")", | ["=", expression] ),  ";";
 
 arguments-list             = [ expression, { ",", expression } ]; 
 
 return_statement           = "return", [ expression ], ";";
 
 lambda_expression          = "(", parameters-list ")", "=>", expression; //zmiana na parameters-list
 
 expression                 = conjunction, { "or", conjunction }; 
 
 conjunction                = relation_term, { "and", relation_term };
 
 relation_term              = additive_term, [ relation_operator , additive_term ];
 
 additive_term              = multiplicative_term, { add_sub_operator, multiplicative_term };
 
 multiplicative_term        = factor, { mul_div_operator, factor };
 
   
 factor                     = ["not"],
                            | ["-"]
                            | literal 
                            | identifier, [ ( ".", identifier, ( , "(", arguments-list, ")" | "(" lambda_expression ")" ) | "(", arguments-list, ")"]
                            | cast_expression
                            | "(", expression, ")"
                            | query statement

 cast_expression            = "$", type_basic, expression;

 type                       = type_basic | type_complex

 type_complex               = dictionary_declaration | tuple_declaration | list_declaration
 type_basic                 = "int" | "float" | "String" | "boolean";

 dictionary_declaration     = "Dictionary", "<", type_basic, ",", type_basic, ">";  
 tuple_declaration          = "Tuple", "<", type_basic, ",", type_basic, ">";
 list_declaration           = "List", "<", type_basic, ">" ;

literal                     = boolean | string | integer | float | complex_literal;
 basic_literal              = boolean | string | integer | float;
 complex_literal            = dictionary_literal | tuple_literal | list_literal

 dictionary_literal         = "|", {basic_literal, ":", basic_literal, [","]}, "|";
 tuple_literal              =  "(", basic_literal, ",", basic_literal, ")";
 list_literal               =  "[", [basic_literal, {",", basic_literal}], "]";

 boolean                    = "true" | "false";
 string                     = '"', { character  }, '"'; 
 float                      = integer, ".", digit, { digit } ; 
 integer                    = non_zero_digit, { digit } 
                            | zero;

 identifier                 = letter, { identifier_chars };
 identifier_chars           = alphanumeric | "_";
 alphanumeric               = letter | digit;

 add_sub_operator           = "+" | "-"
 mul_div_operator           = "*" | "/"
 assign_operant             = "="
 relation_operator          = "<" | "<=" | "==" | ">" | ">=" | "!="

 digit                      = [0-9];
 non_zero_digit             = [1-9];
 zero                       = "0";
 letter                     = [a-zA-Z];
 
 //character                = dowolny znak unicode
```


## **<br>Obsługa błędów:**

Błędy programu są przekazywane użytkownikowi poprzez komunikaty wyświetlane w konsoli.
Wszystkie błędy są traktowane równorzędnie i powodują zatrzymanie wykonywania programu.


### Przykładowe błędy
* #### Lekser:

  * `UnknownTokenException` - nieznany token
     ```
    fn int main() {
      float x% = 1. //bład w definicji identifer
      return 0;
    }
    ```

  * `StringMaxSizeExceededException` - Zbyt długi łańcuch String
     ```
    fn int main() {
      String x = "aaaaaaaa..." //maksymalna długośc to 200 znaków, więc dla czytelności ten przykład pozostaje z ...
      return 0;
    }
    ```

  * `IntMaxValueExceededException` - Wartość int poza zakresem
       ```
    fn int main() {
      int x = 99999999999999999;
      return 0;
    }
    ```

  * `DecimalMaxValueExceededExcpetion` - Wartość float poza zakresem
       ```
    fn int main() {
      floar x = 1.999999999999999999999999999999;
      return 0;
    }
    ```
  * `IdentiferTooLongException` - Zbyt długi identyfikator
       ```
    fn int main() {
      int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa = 2;
      return 0;
    }
    ```

  * `ReachedEOFException` - Dojście do końca pliku 
     ```
     fn int main() {
       String example = "aaa
       return 0;
     }
     ```

  * `Excpetion` - 


Przykładowy komunikat o błędzie:

```
ERROR in Position(line=0, character=0) | Identifier exceeds maximum length with a length of 100
```


<br><br>
* #### Parser
  * `ParsingException` - Bardzo ogólny błąd parsowania, zwraca tokeny jakich oczekiwał nasz program oraz token jaki przeczytał oraz jego pozycje. 
    ```
    fn int main() {
      iny y = 4 //brak srednika
      return 0;
    }
    ```
    ```
    Parsing ERROR in" + Position(line=0, character=0) | EXPECTED tokens: SEMICOLON , GOT: RETURN
    ```


  * `DuplicateIdentiferException` - powtórzona nazwa identyfikatora w przypadku funkcji
    ```
    fn int func() {
      return 0;
    }
  
    fn int func() {
      int x = 3;
      String a = x;
      return 0;
    }
    ```
    ```
    "Parsing ERROR In: Position(line=0, character=0) | Duplicate identifer name: func
    ```


  <br><br>
* #### Interpreter
 
  * `DivisionByZeroInterpretingException ` - Dzielenie przez 0
    ```
    fn int main() {
      return 5 / 0;
    }
    ```

  * `IncorrectReturnedValueTypeInterpretingException` - niepoprawna wartość zwraca przez funkcję
    ```
      fn int main() {
        
        return "String";
    }
    ```

  * `IncorrectDefaultPrintFunctionCallException` - błąd przy wykonaniu funkcji print, np. zła liczba argumentów
   ```
      fn int main() {
        print("Hello", "World");
        return 0;
    }
    ```

  * `InvalidExpressionInterpretingException` - Niepoprawne wyrażenie, operacja arytmetyczna na niepoprawnych typach
      ```
      fn int add(int x, int y) {
        return 3.5 + 3;
    }
    ```

  * `InvalidFunctionCallInterpretingException` - bląd przy wywołaniu funkcji, np. niepoprawna liczba argumentów
    ```
      fn int add(int x, int y) {
        return 3.5 + 3;
    }    ```

  * `InvalidLogicStatementInterpreting` - Niepoprawne wyrażenie, operacja porównania na niepoprawnych typach
    ```
    fn int f() {
      return 3 > "String";
    }
    ```

  * `InvalidNumberofArgumentsException` - zła ilość argumentów w wywołaniu metody
    ```
  
    fn int add(List<int> list) {
      return list.get(0, 1);
    }
    ```
  * `InvalidTypeForMethodCallInterpretingException` - wywołanie metody na zły typie
    ```
  
    fn int add(List<int> list) {
      return list.ifexists(1); //wywolanie metody przewidzianej dla slownikow na liscie
    }
    ```

  * `LocalVariableRepeatedExceptiom` - redefinicja/redeklaracja zmiennej
    ```
  
    fn int add(List<int> list) {
      int x = 0;
      int x = 1;
      }
      ```

  * `NoMainFunctionInterpretingException` - Brak funkcji main w programie
    ```
  
    fn int add(List<int> list) {
      int x = 0;
      int x = 1;
      }
      ```    

  * `NoSuchFunctionInterpretingException` - próba wywołania nieistniejącej funkcji
    ```
  
    fn int add(List<int> list) {
      return sub(0);
      }
      ```    

  * `NoSuchVariableInterpretingException` - próba odwołania się do nieistniejącej zmiennej
    ```
  
    fn int add(List<int> list) {
      return sub(0);
      }
      ```    

  * `NoValueReturnedFromFunctionException` - funkcja nie zwraca wartości, a nie jest typu "void"
    ```
  
    fn int add(List<int> list) {
      
      }
      ```   

  * `UnableToAssignVariableException` - funkcja nie zwraca wartości, a nie jest typu "void"
    ```
  
    fn void add(List<int> list) {
        List<int> x = [1, 2, 3];
        for (String i : x) { //types do not match
            if (i == 2) {
                return i;
            }
        }
      }
      ```     

  * `VariableValueTypeInterpretingException` - błąd podczas operacji na zmiennej, błędny typ
    ```
  
    fn int add(List<int> list) {
      int x = "String";
    return 0;
      }
      ```   

  * `InterpretingException` - w niektórych sytuacjach rzucany jest ogólny wyjątek z odpowiednim komuikatem 
  
    Przykłady (sytuacji jest więcej niż te wymienione poniżej):
    * pętla for dla typów innych niż słownik lub lista
    * ustawienie wartości dla klucza, który nie istnieje w słowniku
    * przekroczenie indeksu podczas operacji get
    * próba przypisania wyrażenia select do typu innych niż słownik lub lista
  

## **<br>Wymagania funkcjonalne:**
* Interpreter pozwala na uruchomienie kodu zapisanego w pliku tekstowym
* Język obsługuje podstawowe typy danych(int, float, bool) oraz konstrukcje językowe (pętle, instrukcje warunkowe)
* Język pozwala na wykonywanie podstawowych operacji arytmetycznych i logicznych na zmiennych
* Język posiada kolekcje - listy i słowniki
* Na słownikach możliwe jest wywołanie metody sort(), która zmieni kolejność elementów w słowniku zgodnie z wyrażeniem, które poda użytkownik
* Na słownikach możliwe jest wykonanie zapytania w stylu LINQ(deklaratywnie), które zwróci przefiltrowane wartości we wskazanej kolejności
* Język umożlwia tworzenie własnych funkcji
* Język jest statycznie typowany
* Język jest silnie typowany
* Zmienne są mutowalne
* Zmienne są przekazywane do funkcji przez wartość

## **<br>Wymagania niefunkcjonalne:**
* Interpreter powinien zapewniać deterministyczne działanie, co oznacza, że ten sam kod źródłowy zawsze produkuje te same wyniki przy identycznych warunkach wejściowych, zapewniając stabilność działania aplikacji.
* Interpreter powinien być łatwy do rozszerzania o dodatkowe funkcje i biblioteki, co umożliwia tworzenie bardziej zaawansowanych programów w oparciu o ten język.
* Interpreter powinien być odpowiednio udokumentowany, aby ułatwić użytkownikom korzystanie z niego, opisując składnię języka, dostępne funkcje, typy danych itp.
* Język zawiera jedynie podstawowe konstrukcje, przez co jest prosty do nauki
* Mechanizm sortowania słownika powinien być zoptymalizowany pod kątem wydajności
* Każdy z modułów powinien być dokładnie przetestowany (wstępny opis sposobu testowania poniżej)

## **<br>Zwięzły opis realizacji:**
Program składa się z modułów, które odpowiadają za kolejne etapy analizy oraz przetwarzania plików wejściowych. 
Moduły zostały umieszczone w oddzielnych folderach, co pozwala na łatwe zarządzanie kodem oraz jego rozbudowę.
Oprócz modułów odpowiedzialnych za analizę leksykalną, składniową i wykonanie, program zawiera moduły do wczytania wejścia oraz zarządzania taokenami.
Każda z części programu posiada swoje zdefiniowane wyjątki, które są rzucane w przypadku błędów.


**1. Analizator leksykalny (Lekser)**
<br>Lekser jest kluczowym modułem odpowiedzialnym za analizę leksykalną tekstu źródłowego.
Jego głównym zadaniem jest przekształcenie ciągu znaków na sekwencje tokenów, które stanowią podstawowe jednostki leksykalne języka programowania.

Proces działania leksera polega na czytaniu kodu źródłowego znak po znaku, aż do momentu wykrycia sekwencji odpowiadającej jednemu zdefiniowanemu tokenowi.
Gdy token zostanie poprawnie zidentyfikowany, jest on przekazywany do parsera. Istotne jest, że lekser czyta nowe znaki tylko wtedy, gdy parser o to wyraźnie prosi.
Taka strategia pomaga w optymalizacji całego procesu analizy tekstu źródłowego.

Moduł lekser składa się z jednej głównej klasy `Lexer`, która posiada metody do analizy leksykalnej. Wykorzystywane są tutaj tokeny, które zostały zdefiniowane za pomocą typu Enum - TokenType(poniżej lista tokenów).
W LexerUtils zostały zdefiniowane metody wspomagające działanie leksera, a nie dotyczące samej analizy lekykalnej

Tokeny zdefiniowane w języku(Nazwa Tokenu `typ`):
* Operatory arytmetyczne
  * Plus `+` 
  * Minus `-`
  * Multiply `*`
  * Divide `/`
* Operatory porównania
  * Equal `=`
  * NotEqual `!=`
  * Greater `>`
  * Less `<`
  * LessEqual `<=`
  * GreaterEqual `>=`
* Operatory logiczne
  * And `and`
  * Or `or`
  * Not `not`
* Typy
  * Integer `int`
  * Float `float`
  * Bool `bool`
  * String `String`
  * Dictionary `Dictionary`
  * List `List`
  * Tuple `Tuple`
  * Void `void`
* Nawiasy
  * CurlyBracketOpen `{`
  * CurlyBracketClose `}`
  * BracketOpen `(`
  * BracketClose `)`
  * SquareBracketOpen `[`
  * SquareBracketClose `]`
  * Pipe `|`
* Pętle i instrukcje warunkowe
  * While `while`
  * For `for`
  * If `if`
  * Elif `elif`
  * Else `else`
* Zapytania na słownikach
  * Select `SELECT`
  * FROM `FROM`
  * Where `WHERE`
  * Order `ORDER BY` //jako jeden token?
  * Ascending `ASC`
  * Descending `DSC`
* Inne
  * MainFunction `main`
  * Function `fn`
  * Return `return`
  * Cast `$`
  * Lambda `=>`
  * StringQuote `"`
  * Semicolon `;`
  * Colon `:`
  * Comma `,`
  * Dot `.`
  * Identifier
  * BooleanLiteral
  * StringLiteral 
  * IntLiteral
  * FloatLiteral
  * EndOfFile

  
**2. Analizator składniowy (Parser)**
<br>Analizator składniowy, nazywany też parserem,
jest kluczowym modułem współpracującym ściśle z analizatorem leksykalnym.
Ten ostatni dostarcza parserowi kolejne tokeny, które są podstawowymi jednostkami leksykalnymi przetwarzanymi przez lekser.

Klasa Parser zajmuje się syntaktyczną analizą tokenów wygenerowanych przez lekser i budowaniem odpowienich obiektów (drzewa składniowego).
Głównym zadaniem parsera jest sprawdzenie, czy otrzymane tokeny są zgodne ze zdefiniowaną gramatyką języka oraz utworzenie z nich odpowiednich struktur.
Dzięki temu możliwe jest rozpoznawanie zdefiniowanych konstrukcji językowych.
Struktury, które parser tworzy implementują interfejs Node, możemy je pogrupować także na Statement, Expression oraz Other, co również zostało zrobione za pomocą interfejsów.

**3. Analizator semantyczny i interpreter**
<br>Interpreter, jest modułem odpowiedzialnym za rozumienie znaczenia wyrażeń zgodnie z regułami semantycznymi języka.
Głównym zadaniem interpretera jest przetwarzanie drzewa rozbioru składniowego (parsowanego wcześniej przez parser) i weryfikacja zgodności semantycznej programu.
Analizator semantyczny dokonuje takich czynności jak sprawdzanie typów danych, rozpoznawanie zmiennych, kontrola poprawności wyrażeń oraz wykrywanie błędów semantycznych.

Interpreter ma za zadanie sekwencyjne wykonanie instrukcji zawartych drzewie zbudowanym przez parser.

W projekcie został zastosowany wzorzec wizytator, klasa interpretingVisitor dziedziczy po interfejsie Visitor, który zawiera metody visit dla każdego typu węzła drzewa składniowego. Każda metoda visit odpowiada za interpretacje danego typu węzła.


## **<br>Sposób testowania:**
Każdy z modułów będzie posiadał testy weryfikujące jego poprawne działanie oraz obsługę wyjątków. Testowanie będzie odbywać się za pomocą biblioteki JUnit<br>
<br> Poniżej przedstawiono kilka przykładów testów, zostały wykonane.

* **Lekser**
   <br>Testy leksera będą testami jednostkowymi. Będą sprawdzać, czy moduł poprawnie przekształca strumień znaków na sekwencję tokenów, co zweryfikuje poprawną analizę leksykalną.  W trakcie testów sprawdzane będą różne przypadki, w tym sytuacje związane z różnymi rodzajami tokenów oraz ewentualne zachowanie wobec błędów leksykalnych. Przestowano tworzenie każdego tokenu z osobna, a także konstrukcje bardziej zaawansowane.
W sumie wykonano 68 testów, które zajmują ponad 1000 linii kodu.
  Przykład testu:  
  ```java
    @Test
    public void testLexerTokenTypesAndPositions() throws IOException, ReachedEOFException, StringMaxSizeExceeded, UnkownTokenException, IntMaxValueExceededException, DecimalMaxValueExceededException, IdentifierTooLongException {
        DataStreamInputReader reader = new DataStreamInputReader(
                """
                   int a = 31234; float b = 3.14; bool c = true; String x = "ala ma kota123";
                   """
        );
        LexerImpl lexer = new LexerImpl(reader);

        assertToken(lexer.next(), TokenType.INTEGER, 1, 0, "int");
        assertToken(lexer.next(), TokenType.IDENTIFIER, 1, 4, "a");
        assertToken(lexer.next(), TokenType.EQUAL, 1, 6, "=");
        assertToken(lexer.next(), TokenType.INT_LITERAL, 1, 8, 31234);
        assertToken(lexer.next(), TokenType.SEMICOLON, 1, 13, ";");

        assertToken(lexer.next(), TokenType.FLOAT, 1, 15, "float");
        assertToken(lexer.next(), TokenType.IDENTIFIER, 1, 21, "b");
        assertToken(lexer.next(), TokenType.EQUAL, 1, 23, "=");
        assertToken(lexer.next(), TokenType.FLOAT_LITERAL, 1, 25, 3.14f);
        assertToken(lexer.next(), TokenType.SEMICOLON, 1, 29, ";");

        assertToken(lexer.next(), TokenType.BOOL, 1, 31, "bool");
        assertToken(lexer.next(), TokenType.IDENTIFIER, 1, 36, "c");
        assertToken(lexer.next(), TokenType.EQUAL, 1, 38, "=");
        assertToken(lexer.next(), TokenType.BOOL_LITERAL, 1, 40, true);
        assertToken(lexer.next(), TokenType.SEMICOLON, 1, 44, ";");

        assertToken(lexer.next(), TokenType.STRING, 1, 46, "String");
        assertToken(lexer.next(), TokenType.IDENTIFIER, 1, 53, "x");
        assertToken(lexer.next(), TokenType.EQUAL, 1, 55, "=");
        assertToken(lexer.next(), TokenType.STRING_LITERAL, 1, 57, "ala ma kota123");
        assertToken(lexer.next(), TokenType.SEMICOLON, 1, 73, ";");
    }
    ```
  
* **Parser**

<br> Parser został przetestowany na dwa sposoby. Po pierwsze, testy jednostkowe sprawdzające, czy parser poprawnie przetwarza listę tokenów na obiekty. Po drugie, testy integracyjne, gdzie parser jest wykorzystywany wraz z lekserem, tzn na wejściu dostaje strumień znaków (obiekt leksera).
W przypadku testów jednostkowych użyto mockito do mockowania zachowania leksera. W sumie wykonano 32 testy, znajdujące się w plikach ParserIntegrationTest oraz ParserUnitTest. Samych asercji jest znacznie więcej


* **Analizator semantyczny i interpreter**

W przypadku interpretera przeprowadzaone testy można nazwać bardziej testami integracyjnymi niż jednostkowymi.
Testowano bowiem, zachowanie programu oraz współpracę trzech modułów: leksera, parsera oraz interpretera.
Asercji poddawano wartość zwracaną przez funkcję main w przypdaku różnych zachowań. W przypadku błędów, sprawdzano czy rzucany jest odpowiedni wyjątek.
Przynajmniej w podstawowym stopniu udało się wykonać testy dla wszystkich klas z drzewa składniowego. Na dzień 04.06.2024 wykonano 97 testów, które zajmują 2200 linii kodu.

Przykładowy test:
```java
    @Test
    public void TestSelectReturn() throws Exception {
        DataStreamInputReader reader = new DataStreamInputReader(
                """
                        fn List<String> main() {
                            Dictionary<String, int> var_dict = |
                            "dog": 3,
                            "cat": 4,
                            "cow": 5,
                            "hamster": 6
                             |;
                           
                             return SELECT (var_dict.value) FROM var_dict WHERE (var_dict.value <= 4);
                            
                           
                         }
                        """
        );
        LexerImpl lexer = new LexerImpl(reader);
        ParserImpl parser = new ParserImpl(lexer);
        Program program = parser.parseProgram();

        Interpreter interpreter = new Interpreter(program);

        List result = (List) interpreter.execute();
        Assert.assertEquals(result, List.of(4, 3));
    }
```


Interpreter był także testowany w sposób bardziej "manualny", wykorzystując plik wejściowy oraz funkcję main naszego projektu. Przykłady plików wejściowych znajdują się w folderze test_examples.

Sumaryczna liczba testów to 227.
