use cientificos;

-- Inserciones para la tabla "proyectos"
INSERT INTO proyectos (id, nombre, horas) VALUES
('P1', 'Proyecto A', 100),
('P2', 'Proyecto B', 150),
('P3', 'Proyecto C', 120),
('P4', 'Proyecto D', 200),
('P5', 'Proyecto E', 180);

-- Inserciones para la tabla "cientificos"
INSERT INTO cientificos (dni, nomApels) VALUES
('12345678A', 'Cientifico 1'),
('87654321B', 'Cientifico 2'),
('56789012C', 'Cientifico 3'),
('34567890D', 'Cientifico 4'),
('90123456E', 'Cientifico 5');

-- Inserciones para la tabla "asignado_a"
INSERT INTO asignado_a (proyecto_id, cientifico_id) VALUES
('P1', '12345678A'),
('P1', '87654321B'),
('P2', '56789012C'),
('P3', '34567890D'),
('P4', '90123456E');
