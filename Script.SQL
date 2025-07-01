CREATE TABLE book_format (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL unique,
    discription VARCHAR(50)
);
INSERT INTO book_format (id, name, discription) VALUES
(200001, 'Physical', 'Printed hard copy'),
(200002, 'eBook', 'Digital book format'),
(200003, 'Audiobook', 'Spoken version of the book');
CREATE TABLE book_status (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL unique,
    discription VARCHAR(50)
);

INSERT INTO book_status (id, name, discription) VALUES
(100001, 'To Read', 'Book not started yet'),
(100002, 'In Progress', 'Currently reading'),
(100003, 'Read', 'Finished reading');


-- GENER

CREATE TABLE book_genre (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255)
);
INSERT INTO book_genre (id, name, description) VALUES
(1, 'Fiction', 'Imaginary content and stories'),
(2, 'Non-fiction', 'Based on facts and real events'),
(3, 'Mystery', 'Focused on solving a crime or puzzle'),
(4, 'Fantasy', 'Includes magical or supernatural elements'),
(5, 'Science Fiction', 'Futuristic or science-based themes'),
(6, 'Romance', 'Centered on love and relationships'),
(7, 'Thriller', 'Suspenseful and exciting stories'),
(8, 'Horror', 'Intended to scare or create fear'),
(9, 'Historical', 'Set in a specific historical period'),
(10, 'Biography', 'Life story of a real person'),
(11, 'Self-help', 'Personal development and motivation'),
(12, 'Poetry', 'Written in verse, expressive form');