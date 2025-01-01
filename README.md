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
