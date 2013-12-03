drop table payment;
drop table question;
drop table quiz;
drop table category;
drop table admin;
drop table achievement;
drop table submit_title;
drop table answer_title;
drop table user;

create table user(
    user_id bigint AUTO_INCREMENT,
    user_name varchar(45),
    password varchar(45),
    email varchar(45),
    userType varchar(4),
    first_name varchar(45),
    middle_name varchar(45),
    last_name varchar(45),
    primary key(user_id)
);


create table answer_title(
    title_id bigint,
    title_name varchar(100),
    primary key(title_id)
);

create table submit_title(
	title_id bigint,
    title_name varchar(100),
    primary key(title_id)
);


create table achievement(
    user_id bigint primary key,
    played_quizzes bigint,
    submit_level bigint,
    answer_level bigint,
    no_of_titles bigint,
    reward_points bigint,
	foreign key(user_id) references user(user_id),
	foreign key(submit_level) references submit_title(title_id),
	foreign key(answer_level) references answer_title(title_id)
);

create table admin(
    user_id bigint,
    user_name varchar(45),
    password varchar(45),
    email varchar(45),
    company_name varchar(100),
    primary key(user_id)
);

create table category(
    category_id bigint,
    parent_id bigint,
    name varchar(45),
    primary key(category_id),
    foreign key(parent_id) references category(category_id)
);

create table quiz(
    quiz_id bigint,
    user_id bigint,
    correct_answers bigint,
    name varchar(45),
    category_id bigint,
    primary key(quiz_id),
    foreign key(category_id) references category(category_id),
    foreign key(user_id) references user(user_id)
);

create table question(
    question_id bigint,
    category_id bigint,
    question varchar(500),
    option1 varchar(500),
    option2 varchar(500),
    option3 varchar(500),
    correct_option varchar(500),
    primary key(question_id),
    foreign key(category_id) references category(category_id)
);

create table payment(
    payment_id bigint,
    user_id bigint,
    item_id bigint,
    payment_type varchar(100),
    primary key(payment_id),
    foreign key(user_id) references user(user_id),
    foreign key(item_id) references quiz(quiz_id)
);