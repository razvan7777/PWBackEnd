INSERT INTO user (id, role, first_name, last_name, username, email, password) VALUES
    (0, 'SURGEON', 'Salahid', 'Dahari', 'Salahid.Dahari', 'Salahid.Dahari@gmail.com', 'password'),
    (1, 'SURGEON', 'George', 'Miller', 'George.Miller', 'George.Miller@gmail.com', 'password');


INSERT INTO surgeon (id, user_id, rating, description, title, image_url) VALUES
  (0, 0, 5, 'Best surgeon', 'Head Surgeon', 'https://familydoctor.org/wp-content/uploads/2018/02/41808433_l.jpg'),
  (1, 1, 4, 'Almost best surgeon', 'Senior Surgeon', 'https://img.freepik.com/free-photo/attractive-young-male-nutriologist-lab-coat-smiling-against-white-background_662251-2960.jpg');