-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 10 Jan 2022 pada 09.59
-- Versi server: 5.7.24
-- Versi PHP: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_apotek`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_obat`
--

CREATE TABLE `jenis_obat` (
  `id_obat` int(11) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenis_obat`
--

INSERT INTO `jenis_obat` (`id_obat`, `nama_obat`, `stok`, `harga`) VALUES
(1, 'Paracetamol', 200, 5000),
(2, 'Promag', 50, 7500);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(200) NOT NULL,
  `namalengkap` varchar(200) NOT NULL,
  `isadmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`id`, `username`, `password`, `namalengkap`, `isadmin`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Wahyudin Akbar', 1),
(2, 'user', 'ee11cbb19052e40b07aac0ca060c23ee', 'Tama', 0),
(3, 'wahyu', 'wahyu', 'Wahyudin A', 0),
(4, 'tama', '407b056f5e6197a948b7f836567fb63d', 'Aditya Pratama', 0),
(5, 'Akbar', '4f033a0a2bf2fe0b68800a3079545cd1', 'Akbar A', 0);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jenis_obat`
--
ALTER TABLE `jenis_obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jenis_obat`
--
ALTER TABLE `jenis_obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
