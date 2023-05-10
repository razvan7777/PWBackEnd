
INSERT INTO user (role, first_name, last_name, username, email, password, image_url) VALUES
    ('SURGEON', 'Salahid', 'Dahari', 'Salahid.Dahari', 'Salahid.Dahari@gmail.com', 'password', 'https://familydoctor.org/wp-content/uploads/2018/02/41808433_l.jpg'),
    ('SURGEON', 'George', 'Miller', 'George.Miller', 'George.Miller@gmail.com', 'password', 'https://img.freepik.com/free-photo/attractive-young-male-nutriologist-lab-coat-smiling-against-white-background_662251-2960.jpg'),
    ('USER', 'Tenche', 'Robert', 'Tenche.Robert', 'Tenche.Robert@gmail.com', 'password', null);

INSERT INTO surgeon (user_id, rating, description, title) VALUES
  (1, 5, 'Best surgeon', 'Head Surgeon'),
  (2, 4, 'Almost best surgeon', 'Senior Surgeon');

INSERT INTO chat (user1_id, user2_id) VALUES
   (3, 1),
   (3, 2);

INSERT INTO message (sent_by_surgeon, text, date_timestamp, chat_id) VALUES
    (false, 'Hello doctor', CURRENT_TIMESTAMP(), 1),
    (true, 'Hello Robert', CURRENT_TIMESTAMP(), 1);
