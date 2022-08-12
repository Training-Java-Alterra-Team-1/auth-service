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
	<ol> 
		<li>Entitas</li>
		<ol>
			<li>1. Dosen (Lecturers)</li>
			<li>2. Mahasiswa (Students)</li>
			<li>3. Jenjang (Degree)</li>
			<li>4. Jurusan (Major)</li>
			<li>5. Fakultas (Department)</li>
			<li>6. Mata Kuliah (Courses)</li>
			<li>7. Transkrip (Student records)</li>
			<li>8. User</li>
			<li>9. Role</li>
		</ol>
		<li>Hubungan antar entitas</li>
		<ol>
			<li>1. 1 Dosen dapat mengampu banyak mata kuliah</li>
			<li>2. 1 Mahasiswa dapat mengambil banyak mata kuliah</li>
			<li>3. 1 Jurusan dapat memiliki banyak dosen</li>
			<li>4. 1 Jurusan dapat memiliki banyak mahasiswa</li>
			<li>5. 1 Jurusan dapat memiliki banyak jenjang/degree (S1, S2, dan S3)</li>
			<li>6. 1 Departemen/Fakultas dapat memiliki banyak jurusan</li>
			<li>7. Tiap-tiap mahasiswa/dosen memiliki 1 user</li>
			<li>8. Tiap-tiap user dapat memiliki banyak roles</li>
		</ol>
	</ol>
</details>