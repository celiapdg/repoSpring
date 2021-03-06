DROP DATABASE IF EXISTS catalogue;
CREATE SCHEMA IF NOT EXISTS catalogue;
USE catalogue;

CREATE TABLE IF NOT EXISTS movies (
	movies_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(100),
    `year` INT,
    image_url VARCHAR(255),
    certificate VARCHAR(45),
    runtime INT,
    imdb_rating FLOAT,
    `description` TEXT,
    metascore INT,
    votes INT,
    gross INT,
    PRIMARY KEY (movies_id)
    );

-- directors
CREATE TABLE IF NOT EXISTS directors (
	directors_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    `name` VARCHAR(45),
    about TEXT,
    PRIMARY KEY (directors_id)
    );

CREATE TABLE IF NOT EXISTS movies_directors (
	movies_id INT NOT NULL,
    directors_id INT NOT NULL,
    PRIMARY KEY (movies_id, directors_id),
    FOREIGN KEY (movies_id) REFERENCES movies(movies_id) ON DELETE CASCADE,
    FOREIGN KEY (directors_id) REFERENCES directors(directors_id) ON DELETE CASCADE
    );

-- stars
CREATE TABLE IF NOT EXISTS stars (
	stars_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    `name` VARCHAR(45),
    about TEXT,
    PRIMARY KEY (stars_id)
    );

CREATE TABLE IF NOT EXISTS movies_stars (
	movies_id INT NOT NULL,
    stars_id INT NOT NULL,
    PRIMARY KEY (movies_id, stars_id),
	FOREIGN KEY (movies_id) REFERENCES movies(movies_id) ON DELETE CASCADE,
    FOREIGN KEY (stars_id) REFERENCES stars(stars_id) ON DELETE CASCADE
    );

-- genres
CREATE TABLE IF NOT EXISTS genres (
	genres_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    `name` VARCHAR(45),
    PRIMARY KEY (genres_id)
    );

CREATE TABLE IF NOT EXISTS movies_genres (
	movies_id INT NOT NULL,
    genres_id INT NOT NULL,
    PRIMARY KEY (movies_id, genres_id),
    FOREIGN KEY (movies_id) REFERENCES movies(movies_id) ON DELETE CASCADE,
    FOREIGN KEY (genres_id) REFERENCES genres(genres_id) ON DELETE CASCADE
    );
    

# Introduciendo los datos en las tablas (INSERTS)
INSERT INTO 
	movies (title, `year`, image_url, certificate, runtime, imdb_rating, `description`, metascore, votes, gross) 
VALUES
	('Pulp Fiction', 1994, 'https://www.imdb.com/title/tt0110912/mediaviewer/rm4283528192/?ref_=tt_ov_i', 'NO', 1, 8.9, 'Las vidas de dos mafiosos, un boxeador, la esposa de un g??nster y un par de bandidos se entrelazan en cuatro historias de violencia y redenci??n', 89, 2000000, 1),
	('Interstellar', 2014, 'https://www.imdb.com/title/tt0816692/mediaviewer/rm2861200384/?ref_=tt_ov_i', 'NO', 1, 8.6, 'Un equipo de exploradores viaja a trav??s de un agujero de gusano en el espacio en un intento de garantizar la supervivencia de la humanidad.', 86, 1700000, NULL),
    ('The Equalizer: El protector', 2014,   'https://www.imdb.com/title/tt0455944/mediaviewer/rm2786566657/?ref_=tt_ov_i', 'NO', 1, 7.2, 'Un hombre cree que ha dejado su misterioso pasado atr??s y que puede llevar una nueva vida en paz. Pero cuando conoce a una joven bajo el control de g??nsteres rusos ultra-violentos, no puede quedarse de brazos cruzados - tiene que ayudarla.', 72, 364000, NULL),
    ('El indomable Will Hunting', 1997,   'https://www.imdb.com/title/tt0119217/mediaviewer/rm2548229889/?ref_=tt_ov_i', 'NO', 1, 8.3, 'Will Hunting, un conserje del MIT, tiene un don para las matem??ticas, pero necesita la ayuda de un psic??logo para encontrar el rumbo de su vida.', 83, 941000, NULL),
    ('Regreso al futuro', 1895,  'https://www.imdb.com/title/tt0088763/mediaviewer/rm3415438592/?ref_=tt_ov_i', 'NO', 1, 8.5, 'Marty McFly, un estudiante de secundaria de 17 a??os, es enviado accidentalmente treinta a??os al pasado en un DeLorean que viaja en el tiempo, inventado por su gran amigo, el exc??ntrico cient??fico Doc Brown.', 85, 12000000, NULL),
	('Kill Bill: Volumen 1', 2003,  'https://www.imdb.com/title/tt0266697/mediaviewer/rm3086980609/?ref_=tt_ov_i', 'NO', 1, 8.2, 'Tras despertar de un coma de cuatro a??os, una antigua asesina se venga del equipo de asesinos que la traicion??.', 82, 11000000, NULL),
    ('Pearl Harbor', 2001,  'https://www.imdb.com/title/tt0213149/mediaviewer/rm2150209536/?ref_=tt_ov_i', 'NO', 1, 6.2, 'Un cuento de guerra y amor mezclado con historia, sigue a dos amigos de toda la vida y a una hermosa enfermera que se encuentran atrapados en el horror de la ma??ana de domingo m??s famosa de 1941.', 62, 3290000, NULL),
    ('The Purge: La noche de las bestias', 2013,  'https://www.imdb.com/title/tt2184339/mediaviewer/rm4233849600/?ref_=tt_ov_i', 'NO', 1, 5.7, 'Una familia adinerada es retenida como reh??n por albergar al objetivo de un sindicato asesino durante la Purga, un per??odo de 12 horas en el que cualquier delito es legal.', 57, 2200000, NULL),
	('N??ufrago', 2013,  'https://www.imdb.com/title/tt0162222/mediaviewer/rm2572386305/?ref_=tt_ov_i', 'NO', 1, 7.8, 'Un ejecutivo de FedEx debe transformarse f??sica y emocionalmente para sobrevivir a un aterrizaje forzoso en una isla desierta.', 78, 578000, NULL);

INSERT INTO 
	directors (`name`, about) 
VALUES
	('Robert Zemeckis', 'Un ni??o prodigio con efectos especiales, Robert es del campo de la realizaci??n de pel??culas de Spielberg ( Steven Spielberg produjo muchas de sus pel??culas). Trabajando generalmente con su compa??ero de escritura Bob Gale , las pel??culas anteriores de Robert muestran que tiene talento para la comedia alocada'),
	('Quentin Tarantino', 'Quentin Jerome Tarantino es un director, productor, guionista, escritor y editor estadounidense. Su carrera comenz?? a finales de la d??cada de 1980, cuando escribi?? y dirigi?? My Best Friends Birthday'),
    ('Christopher Nolan', 'Christopher Edward Nolan es un director de cine, guionista, productor y editor brit??nico-estadounidense. Nacido y criado en Londres, Nolan desarroll?? un inter??s por el cine desde una edad temprana. Despu??s de estudiar literatura inglesa en el University College de Londres, debut?? en el largometraje con Following.'),
    ('Antoine Fuqua', 'Antoine Fuqua es un director de cine estadounidense. Dirigi?? Training Day, The Replacement Killers, Tears of the Sun, King Arthur, Shooter y Brooklyns Finest, entre otras pel??culas'),
	('Gus Van Sant', 'Gus Van Sant es un director de cine, productor, guionista y escritor estadounidense. Candidato al Premio ??scar como mejor director por Good Will Hunting y Milk y ganador de la Palma de Oro en el prestigioso festival de Cannes por Elephant.'),
    ('Michael Bay', 'Michael Benjamin Bay ??? es un cineasta estadounidense conocido por dirigir y producir pel??culas de acci??n de gran presupuesto caracterizadas por su narraci??n r??pida y el uso extensivo de efectos especiales, incluyendo frecuentemente explosiones.??????'),
	('James DeMonaco', 'James DeMonaco??? es un guionista, director y productor estadounidense m??s conocido por su trabajo en las pel??culas de The Purge, ??? The Purge: Anarchy, The Purge: Election Year, ??? y Staten Island.???');

INSERT INTO 
	movies_directors(movies_id, directors_id)
VALUES
	(1, 2), (2,3), (3,4), (4,5), (5,1), (6,2), (7, 6), (8, 7), (9, 1);

INSERT INTO
	stars(`name`, about)
VALUES
	('John Travolta', 'John Joseph Travolta es un actor, cantante, m??sico, bailar??n, productor de cine, productor discogr??fico de cine, televisi??n y teatro, adem??s de piloto estadounidense y ganador de un Globo de Oro.'),
	('Uma Thurman', 'Uma Karuna Thurman es una actriz de cine y exmodelo estadounidense nominada al ??scar y ganadora del Globo de Oro. Comenz?? como modelo profesional y acab?? dedic??ndose al cine en 1988, donde ha trabajado tanto en producciones de bajo presupuesto como en superproducciones de grandes estudios.'),
	('Samuel L. Jackson', 'Samuel Leroy Jackson (Washington D. C., 21 de diciembre de 1948), conocido como Samuel L. Jackson, es un actor y productor de cine, televisi??n y teatro estadounidense. Ha sido candidato al premio ??scar, a los Globos de Oro y al Premio del Sindicato de Actores, as?? como ganador de un BAFTA al mejor actor de reparto y en 2022 se le entreg?? un ??scar honor??fico a su trayectoria profesional.'),
    ('Matthew McConaughey', 'Matthew David McConaughey (Uvalde, Texas; 4 de noviembre de 1969) es un actor y productor de cine y televisi??n estadounidense. Es ganador de un premio ??scar, un Globo de Oro y un SAG. Conocido por su participaci??n en pel??culas como Dazed and Confused (1993), A Time to Kill (1996), Contact (1997), Frailty (2001), We Are Marshall (2006), Killer Joe (2011), The Lincoln Lawyer (2011), Magic Mike (2012), Bernie (2012), Mud (2012), El lobo de Wall Street (2013), Dallas Buyers Club (2013), Interstellar (2014), Free State of Jones (2016) y The Gentlemen (2019).'),
	('Anne Hathaway', 'Anne Jacqueline Hathaway (Brooklyn, Nueva York; 12 de noviembre de 1982) es una actriz estadounidense. Gan?? el premio ??scar, el Globo de Oro, el BAFTA y el SAG a la Mejor actriz de reparto por su interpretaci??n en Los miserables.'),
	('Jessica Chastain', 'Jessica Chastain, ganadora del Oscar tras su papel en Los ojos de Tammy Faye, es una de las actrices de su generaci??n m??s solicitadas de Hollywood. Ha recibido numerosas nominaciones y reconocimientos mundiales por su trabajo de LA Film Critics, British Academy of Film and TV, Broadcast Film Critics, HFPA, National Board of Review, Screen Actors Guild, Film Independent y de la Academy of Motion Pictures Arts and Sciences, entre otras.Chastain, que comenz?? su carrera con peque??os papeles en series como Urgencias o Veronica Mars, di?? el salto al cine en 2008 con la pel??cula independiente Jolene. Sin embargo, fueron sus papeles en las pel??culas Take Shelter y El ??rbol de la vida los que le dieron a conocer entre el gran p??blico.'),
	('Denzel Washington', 'Denzel Hayes Washington, Jr. es un actor y director de cine estadounidense, ganador de tres Globos de Oro, un Premio del Sindicato de Actores, un premio Tony y dos premios ??scar; estos por las cintas Glory como mejor actor de reparto en 1989, y por D??a de entrenamiento como mejor actor principal en 2001.'),
	('Marton Csokas', 'Marton Csokas es un actor h??ngaro-neozeland??s, pues naci?? en Nueva Zelanda, pero es hijo de padre h??ngaro. Reside de manera habitual en los Estados Unidos. En 1989 termin?? sus estudios en la New Zealand Drama School.'),
	('Chlo?? Grace Moretz', 'Chlo?? Grace Moretz es una actriz y modelo estadounidense. Sus primeras actuaciones las realiz?? a los siete a??os en series y pel??culas como The Amityville Horror, Days of Summer, Diary of a Wimpy Kid, Mujeres desesperadas o Dirty Sexy Money. Con estas producciones fue nominada a varios Premios Young Artist.'),
    ('Robin Williams', 'Robin McLaurin Williams ??????fue un comediante, actor y actor de voz estadounidense, ganador de un Premio ??scar, cinco Globos de Oro, un Premio del Sindicato de Actores, dos Premios Emmy y tres Premios Grammy. Fue conocido sobre todo por sus actuaciones en pel??culas c??micas tales como Mrs.'),
	('Matt Damon', 'Matthew Paige Damon, conocido simplemente como Matt Damon, es un actor, guionista y productor estadounidense. Desde temprana edad se destac?? en sus estudios y comenz?? a mostrar inter??s por la actuaci??n durante la secundaria gracias a sus maestros.'),
	('Ben Affleck', 'Benjamin G??za Affleck-Boldt, conocido simplemente como Ben Affleck, es un actor, director, productor y guionista estadounidense.'),
	('Michael J. Fox', 'Michael Andrew Fox, m??s conocido como Michael J. Fox, es un ex-actor canadiense-estadounidense, ?????? ocasionalmente es cantante y m??sico. Su carrera en el cine y la televisi??n comenz?? a fines de los a??os 70. Entre sus papeles se destacan: Marty McFly en la trilog??a de Volver al futuro; Alex P.'),
	('Christopher Lloyd', 'Christopher Alan Lloyd es un actor estadounidense. Ha interpretado a Doc Emmett Brown en la trilog??a de Back to the Future, a Fester Addams en The Addams Family y Addams Family Values, y al Juez Doom en ??Qui??n enga???? a Roger Rabbit?.'),
	('Lea Thompson', 'Lea Kathleen Thompson es una actriz estadounidense conocida principalmente por su papel como Lorraine McFly en la trilog??a Back to the Future adem??s de por La Clave Del ??xito con Tom Cruise y Tibur??n 3. '),
    ('David Carradine', 'John Arthur Carradine, conocido en el cine como David Carradine, fue un actor estadounidense, c??lebre por su trabajo en la serie de televisi??n Kung fu y la pel??cula Kill Bill.?????? Fue miembro de la familia de actores Carradine la cual se inici?? con su padre, John Carradine.'),
	('Daryl Hannah', 'Daryl Christine Hannah es una actriz estadounidense. Hizo su debut en la pantalla en 1978. Salt?? a la fama tras aparecer en filmes como Blade Runner, donde da vida a la replicante Pris, o la comedia Splash, en la que interpreta a la sirena Madison.'),
    ('Kate Beckinsale', 'Kathrin Romany "Kate" Beckinsale es una actriz y modelo brit??nica con un largo recorrido, conocida por su papel como Selene en la saga Underworld entre otras pel??culas de acci??n y por pel??culas de romance como Much Ado About Nothing o Serendipity.'),
	('Josh Hartnett', 'Joshua Daniel "Josh" Hartnett es un actor y productor de cine estadounidense, protagonista de filmes como La dalia negra, Black Hawk Down, Lucky Number Slevin, Pearl Harbor o Wrath of Man.'),
    ('Ethan Hawke', 'Ethan Green Hawke, conocido como Ethan Hawke, es un actor, escritor y director estadounidense. Nominado a los premios ??scar en cuatro ocasiones ???tanto como actor y guionista??? y a un premio Tony'),
    ('Lena Headey', 'Lena Kathren Headey es una actriz brit??nica conocida por su papeles de la reina Gorgo en 300, Sarah Connor en Terminator: The Sarah Connor Chronicles y el de Cersei Lannister en Game of Thrones.'),
	('Max Burkholder', 'Max Henry Wolf Burkholder es un actor estadounidense conocido por interpretar a Max Braverman en la serie Parenthood. Anteriormente trabaj?? como actor de voz en series animadas como The Land Before Time y en My Friends Tigger & Pooh donde prestaba su voz a Chomper y a Roo respectivamente.'),
	('Tom Hanks', 'Thomas Jeffrey Hanks, m??s conocido como Tom Hanks, es un actor y productor estadounidense??????. Es uno de los int??rpretes m??s reconocidos de Hollywood, y muchas de sus pel??culas, ya sean dramas o comedias, han recibido reconocimiento internacional.'),
    ('Helen Hunt', 'Helen Elizabeth Hunt, conocida como Helen Hunt, es una actriz y cineasta estadounidense, ganadora de los premios ??scar, Globo de Oro y Emmy.'),
	('Paul Sanchez', 'Paul es nativo de California, igualmente orgulloso de sus ra??ces mexicano-americanas y nativas americanas. Despu??s de graduarse de la escuela secundaria, Paul recibi?? una beca deportiva para la Universidad de Haw??i, se gradu?? con dos t??tulos y decidi?? probar suerte como actor.');

INSERT INTO
	movies_stars(movies_id, stars_id)
VALUES
	(1, 1), (1, 2), (1, 3), (2, 4), (2, 5), (2, 6), (3, 7), (3, 8), (3, 9), (4, 10), (4, 11), (4, 12), (5, 13), (5, 14), (5, 15), (6, 2), (6, 16), (6, 17), (7, 12), (7, 18), (7, 19),
    (8, 20), (8, 21), (8, 22), (9, 23), (9, 24), (9, 25);

INSERT INTO
	genres(`name`)
VALUES 
	('CRIMEN'),
    ('DRAMA'),
    ('AVENTURA'),
    ('CIENCIA FICCI??N'),
	('ACCI??N'),
    ('ROMANCE'),
    ('COMEDIA'),
	('SUSPENSE');

INSERT INTO 
	movies_genres(movies_id, genres_id)
VALUES 
	(1, 1), (1, 2), (2, 3), (2, 2), (2, 4), (3, 5), (3, 1), (3, 2), (4, 2), (4, 6), (5, 3), (5, 7), (5, 8);
