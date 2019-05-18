Drop TABLE if EXISTS parts;

CREATE TABLE parts (
    id int primary key not null AUTO_INCREMENT, 
    name varchar(100) not null,
    number int,
    relevance int
    );
    
INSERT into parts (name, number, relevance) VALUES ('Motherboard', 4, 'Yes');
INSERT into parts (name, number, relevance) VALUES ('Power supply', 3, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('Video card', 7, 'Yes'); 
INSERT into parts (name, number, relevance) VALUES ('Monitor', 4, 'Yes'); 
INSERT into parts (name, number, relevance) VALUES ('Mouse', 10, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('Keyboard', 10, 'Yes'); 
INSERT into parts (name, number, relevance) VALUES ('Sound card', 7, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('CPU', 6, 'Yes'); 
INSERT into parts (name, number, relevance) VALUES ('HDD', 5, 'Yes'); 
INSERT into parts (name, number, relevance) VALUES ('CD/DVD', 2, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('Headphones', 3, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('RAM', 4, 'Yes'); 
INSERT into parts (name, number, relevance) VALUES ('SSD', 3, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('Speaker', 2, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('Printer', 1, 'No'); 
INSERT into parts (name, number, relevance) VALUES ('Computer case', 3, 'Yes');
INSERT into parts (name, number, relevance) VALUES ('Keyboard custom', 4, 'No');
INSERT into parts (name, number, relevance) VALUES ('Mouse custom', 2, 'No');
INSERT into parts (name, number, relevance) VALUES ('Scanner', 1, 'No');
INSERT into parts (name, number, relevance) VALUES ('Bag', 7, 'No');
