CREATE DATABASE agencia_viagens;

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
                            user_id INT NOT NULL,
                            role_id INT NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
                            FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

CREATE TABLE destino (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         localizacao VARCHAR(100) NOT NULL,
                         descricao TEXT,
                         media_avaliacoes DOUBLE PRECISION DEFAULT 0,
                         quantidade_avaliacoes INT DEFAULT 0
);

INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users (username, password) VALUES ('admin', 'ecKYUghtOreNTicisHeoNTe');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);


INSERT INTO destino (nome, localizacao, descricao, media_avaliacoes, quantidade_avaliacoes)
VALUES
    ('Praia do Forte', 'Bahia, Brasil', 'Uma das praias mais belas e famosas do Brasil.', 4.8, 150),
    ('Torre Eiffel', 'Paris, França', 'Um dos monumentos mais icônicos do mundo.', 4.7, 200),
    ('Parque Yellowstone', 'Wyoming, EUA', 'O primeiro parque nacional do mundo, famoso por suas fontes termais e geisers.', 4.9, 180),
    ('Machu Picchu', 'Cusco, Peru', 'Uma das Sete Maravilhas do Mundo, a cidadela Inca mais preservada.', 5.0, 250),
    ('Monte Fuji', 'Honshu, Japão', 'Um símbolo do Japão, perfeito para trilhas e vistas deslumbrantes.', 4.6, 130),
    ('Coliseu', 'Roma, Itália', 'Um dos monumentos mais visitados da Itália e símbolo do Império Romano.', 4.8, 300),
    ('Ilhas Maldivas', 'Oceano Índico', 'Um paraíso tropical conhecido por suas águas cristalinas e resorts de luxo.', 4.9, 400),
    ('Grande Muralha', 'China', 'Uma das construções mais impressionantes da história, estendendo-se por milhares de quilômetros.', 4.7, 220),
    ('Cataratas do Niágara', 'Ontário, Canadá', 'Uma das cachoeiras mais impressionantes e visitadas do mundo.', 4.8, 180),
    ('Praia de Copacabana', 'Rio de Janeiro, Brasil', 'Uma das praias mais famosas do mundo, no coração do Rio de Janeiro.', 4.5, 250);