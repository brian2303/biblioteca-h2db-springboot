DROP TABLE IF EXISTS book_loan;
CREATE TABLE book_loan(
    id INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(10) NOT NULL,
    user_identification VARCHAR(10) NOT NULL,
    user_type VARCHAR(1) NOT NULL,
    maximum_return_date DATE
);