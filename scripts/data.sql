create database javapoz20blog;
use javapoz20blog;

CREATE TABLE `users` (
                         `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         `username` VARCHAR(50) NOT NULL UNIQUE,
                         `password` VARCHAR(250) NOT NULL,
                         `token` VARCHAR(50),
                         `active` BOOLEAN NOT NULL DEFAULT false
);

insert into `users` (`username`, `password`, `active`) values
('user1', '$2a$12$9HPJbTGqBZ8bH.iGHOxOQ.y/xPoOYTluCY7.vRcwuiHeNvPVRyyE2', true),
('user2', '$2a$12$8VSkdctu27QYXTa30lmpEeAmHlAI0fyqUl13pY3qQ5J7e2DI4zZVK', true);