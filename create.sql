CREATE TABLE Usuario (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(256) NOT NULL,
                         email VARCHAR(256) NOT NULL UNIQUE,
                         senha VARCHAR(100) NOT NULL,
                         papel ENUM('Paciente', 'Medico', 'Admin') NOT NULL,
                         especialidade VARCHAR(100), -- Apenas para Médicos

                         CHECK (
                             (papel = 'Medico' AND especialidade IS NOT NULL) OR
                             (papel <> 'Medico' AND especialidade IS NULL)
                             )
);

CREATE TABLE Consulta (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          data DATE NOT NULL,
                          hora TIME NOT NULL,
                          status ENUM('Confirmada', 'Pendente') NOT NULL,

                          paciente_id INT NOT NULL,
                          medico_id INT NOT NULL,

                          FOREIGN KEY (paciente_id) REFERENCES Usuario(id),
                          FOREIGN KEY (medico_id) REFERENCES Usuario(id),

                          CHECK (paciente_id <> medico_id)
);

CREATE TABLE Diagnostico (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             descricao TEXT NOT NULL,

                             consulta_id INT NOT NULL UNIQUE,

                             FOREIGN KEY (consulta_id) REFERENCES Consulta(id)
);

CREATE TABLE Prescricao (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            medicamento VARCHAR(100) NOT NULL,
                            dosagem VARCHAR(50) NOT NULL,
                            frequencia VARCHAR(50) NOT NULL,
                            data DATE NOT NULL,
                            hora TIME NOT NULL,

                            diagnostico_id INT NOT NULL,

                            FOREIGN KEY (diagnostico_id) REFERENCES Diagnostico(id)
);
