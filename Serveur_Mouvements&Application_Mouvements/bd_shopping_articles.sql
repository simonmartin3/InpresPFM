create table articles
(
    idArticle int          not null
        primary key,
    nom       varchar(255) not null,
    quantite  int          not null,
    prix      float        null
)
    charset = utf8;

INSERT INTO bd_shopping.articles (idArticle, nom, quantite, prix) VALUES (1, 'PlayStation 5', 9, 399.99);
INSERT INTO bd_shopping.articles (idArticle, nom, quantite, prix) VALUES (2, 'TV Sony KD-55XH9096', 7, 999.99);
INSERT INTO bd_shopping.articles (idArticle, nom, quantite, prix) VALUES (3, 'Barre son Sony HT-G700', 10, 299.99);