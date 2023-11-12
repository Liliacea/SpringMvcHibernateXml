
CREATE TABLE public.person(
                      id INT  GENERATED always as identity unique ,
                      name  varchar(25) NOT NULL,
                      age int not null

);
