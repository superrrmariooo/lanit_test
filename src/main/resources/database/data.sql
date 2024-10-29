insert into persons values
(1, DATE '2001-01-01', 'Андрей'),
(2, DATE '2002-02-02', 'Виктор'),
(3, DATE '2003-03-03', 'Дмитрий'),
(4, DATE '2004-04-04', 'Артем'),
(5, DATE '2005-05-05', 'Денис')
on conflict do nothing;

insert into cars values
(1, 500, 'BMW-X5', 1),
(2, 500, 'BMW-X3',2),
(3, 500, 'Mercedes-E63',2),
(4, 500, 'Mercedes-GLE',3),
(5, 500, 'BMW-X6',4),
(6, 500, 'BMW-X7',5),
(7, 500, 'Audi-RS7',5),
(8, 500, 'Lada-2114',5)
on conflict do nothing;