INSERT INTO platforms (name, company, id) VALUES
                                              ('PS1', 'SONY', gen_random_uuid()),
                                              ('PS2', 'SONY', gen_random_uuid()),
                                              ('PS3', 'SONY', gen_random_uuid()),
                                              ('PS4', 'SONY', gen_random_uuid()),
                                              ('PS5', 'SONY', gen_random_uuid())
ON CONFLICT (name) DO NOTHING ;