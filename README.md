# Microservice Auth Sistem Akademik

Anggota Tim Developer:
* Jalaluddin Al Mursyidy Fadhlurrahman
* Djodi Ramadhan

Proyek ini merupakan bentuk sistem akademik bagi lingkungan Perguruan Tinggi yang terdiri dari 3 _microservices_ :
1. Service Auth
2. Service Registrasi Mahasiswa Baru
3. Service Perwalian 

Berikut merupakan _Entity Relationship Diagram_ untuk proyek ini:
![alt text](https://github.com/Training-Java-Alterra-Team-1/sistem-akademik-auth/blob/master/ERD%20-%20Sistem%20Informasi%20Akademik.png "ER Diagram")

<details>
	<summary>Penjelasan ERD</summary>
	1. Entitas
		1. Dosen (Lecturers)
		2. Mahasiswa (Students)
		3. Jenjang (Degree)
		4. Jurusan (Major)
		5. Fakultas (Department)
		6. Mata Kuliah (Courses)
		7. Transkrip (Student records)
		8. User
		9. Role
	2. Hubungan antar entitas
		1. 1 Dosen dapat mengampu banyak mata kuliah
		2. 1 Mahasiswa dapat mengambil banyak mata kuliah
		3. 1 Jurusan dapat memiliki banyak dosen
		4. 1 Jurusan dapat memiliki banyak mahasiswa
		5. 1 Jurusan dapat memiliki banyak jenjang/degree (S1, S2, dan S3)
		6. 1 Departemen/Fakultas dapat memiliki banyak jurusan
		7. Tiap-tiap mahasiswa/dosen memiliki 1 user
		8. Tiap-tiap user dapat memiliki banyak roles

</details>