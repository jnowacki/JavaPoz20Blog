create database javapoz20blog;
use javapoz20blog;

CREATE TABLE `users` (
                         `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         `username` VARCHAR(50) NOT NULL UNIQUE,
                         `password` VARCHAR(250) NOT NULL
);

insert into `users` (`username`, `password`) values
('user1', '$12$NN3NQlXeFK3tnVyAuri.pul.91OVcp21eXNoel5mWoLqVbr/LZ29G'),
('user2', '$12$z6bnC69txY9Cpry2XS1WjuXzUrATuDusDG.PewEHy1pOxZpU3i2Wa');