
INSERT INTO user (role, first_name, last_name, username, email, password, image_url) VALUES
    ('SURGEON', 'Salahid', 'Dahari', 'SalahidDahari', 'Salahid.Dahari@gmail.com', '$2a$10$MI9xPRKbg5hGbl8s.3wJJuJTedtuA0N3DqsQsLjmuSPTVNpZ6IiZG', 'https://familydoctor.org/wp-content/uploads/2018/02/41808433_l.jpg'),
    ('SURGEON', 'George', 'Miller', 'GeorgeMiller', 'George.Miller@gmail.com', '$2a$10$k8q1r5/mOxYi7FABA3Z.Tee19JlhQvJfxWCbBk.N8xloRPP/fgIfS', 'https://img.freepik.com/free-photo/attractive-young-male-nutriologist-lab-coat-smiling-against-white-background_662251-2960.jpg'),
    ('SURGEON', 'Susan', 'Gibbs', 'SusanGibbs', 'Susan.Gibbs@gmail.com', '$2a$10$PtNreneS7Mvxn6uJqyG6S.GcSk9MR6CQBCNRlGnXPLAcfgE1mRui6', 'https://media.istockphoto.com/id/1189304032/photo/doctor-holding-digital-tablet-at-meeting-room.jpg?s=612x612&w=0&k=20&c=RtQn8w_vhzGYbflSa1B5ea9Ji70O8wHpSgGBSh0anUg=');

INSERT INTO surgeon (user_id, rating, description, title) VALUES
  (1, 5, 'Best surgeon', 'Head Surgeon'),
  (2, 4, 'Almost best surgeon', 'Senior Surgeon'),
  (3, 2, 'Bad surgeon', 'Junior Surgeon');
