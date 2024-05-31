3.Wyszukiwanie najkrótszej ścieżki 

[SPIS TREŚCI]
proj
    (.idea)
        (.idea/.gitignore)
        (.idea/jpa-buddy.xml)
        (.idea/misc.xml)
        (.idea/modules.xml)
        (.idea/workspace.xml)
    (out/production/proj)
        (out/production/proj/Main.class)
        (out/production/proj/PathHolder.class)
    (src)
        (src/Main.java)
(proj.iml)
(README.md)



Lista i krótki opis zaimplementowanych funkcjonalności:
Po uruchomieniu programu użytkownik poproszony zostanie o podanie wymiarów planszy i uzupełnienie go liczbami.
Najkrótsza droga znajdowana jest poprzez obliczenie wszystkich możliwych tras i zapisanie tej, której wartość będzie najmniejsza.
Obliczanie trasy odbywa się za pomocą funkcji "processPath", która wywoływana jest rekurencyjne.
Za każdym razem gdy dojdziemy do końca planszy, cofamy się o dany krok aby obliczyć kolejną możliwą drogę.

Instrukcja obsługi:
Aplikację uruchomić można z wybranego środowiska programistycznego wspierającego jave.
Aplikacja stworzona z użyciem Javy 17