CREATE TABLE guests (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone_number VARCHAR(20),
    PRIMARY KEY (id)
);


INSERT INTO guests (first_name, last_name, phone_number) VALUES ('John', 'Doe', '123456789');
INSERT INTO guests (first_name, last_name, phone_number) VALUES ('Jane', 'Smith', '987654321');
INSERT INTO guests (first_name, last_name, phone_number) VALUES ('Alice', 'Johnson', '555123456');


CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    status VARCHAR(50),
    due_date DATE,
    guest_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (guest_id) REFERENCES guests(id)
);


INSERT INTO tasks (title, description, status, due_date, guest_id) VALUES ('Buy Alcohol', 'Buy wine and vodka for the party.', 'Pending', '2024-12-31', 1);
INSERT INTO tasks (title, description, status, due_date, guest_id) VALUES ('Buy Grapes', 'Buy grapes to eat under the table during the party.', 'Pending', '2024-12-31', 2);
INSERT INTO tasks (title, description, status, due_date, guest_id) VALUES ('Decorate House', 'Decorate the house with Christmas lights and ornaments.', 'In Progress', '2024-12-30', 3);
INSERT INTO tasks (title, description, status, due_date, guest_id) VALUES ('Prepare Music Playlist', 'Create a fun music playlist for New Years Eve.', 'Completed', '2024-12-31', 1);