
INSERT INTO user (role, first_name, last_name, username, email, password, image_url) VALUES
    ('SURGEON', 'Salahid', 'Dahari', 'Salahid.Dahari', 'Salahid.Dahari@gmail.com', 'password', 'https://familydoctor.org/wp-content/uploads/2018/02/41808433_l.jpg'),
    ('SURGEON', 'George', 'Miller', 'George.Miller', 'George.Miller@gmail.com', 'password', 'https://img.freepik.com/free-photo/attractive-young-male-nutriologist-lab-coat-smiling-against-white-background_662251-2960.jpg'),
    ('SURGEON', 'Susan', 'Gibbs', 'Susan.Gibbs', 'Susan.Gibbs@gmail.com', 'password', 'https://media.istockphoto.com/id/1189304032/photo/doctor-holding-digital-tablet-at-meeting-room.jpg?s=612x612&w=0&k=20&c=RtQn8w_vhzGYbflSa1B5ea9Ji70O8wHpSgGBSh0anUg=');

INSERT INTO surgeon (user_id, rating, description, title) VALUES
  (1, 5, 'Best surgeon', 'Head Surgeon'),
  (2, 4, 'Almost best surgeon', 'Senior Surgeon'),
  (3, 2, 'Bad surgeon', 'Junior Surgeon');
