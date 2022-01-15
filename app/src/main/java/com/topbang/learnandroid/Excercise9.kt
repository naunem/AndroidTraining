package com.topbang.learnandroid

//Thư viện trung tâm đại học quốc gia có nhu cầu quản lý việc mượn, trả sách.
// Sinh viên đăng ký tham gia mượn sách thông qua thẻ mà thư viện cung cấp.
//Với mỗi thẻ sẽ lưu các thông tin sau:
// Mã phiếu mượn, ngày mượn, hạn trả, số hiệu sách, và các thông tin cá nhân của sinh viên mượn sách.
// Các thông tin của sinh viên mượn sách bao gồm: Họ tên, tuổi, lớp.
//Để đơn giản cho ứng dụng console. Chúng ta mặc định ngày mượn, ngày trả là số nguyên dương.
//Yêu cầu 1: Xây dựng lớp SinhVien để quản lý thông tin của mỗi sinh viên.
//Yêu cầu 2: Xây dựng lớp TheMuon để quản lý việc mượn trả sách của các sinh viên.
//Yêu cầu 3: Xây dựng các phương thức: Thêm, xoá theo mã phiếu mượn và hiển thị thông tin các thẻ mượn.

open class SinhVien(val hoTen: String, val tuoi: Int, val lop: String)
class TheMuon(
    hoTen: String,
    tuoi: Int,
    lop: String,
    val maPhieuMuon: String,
    val ngayMuon: Int,
    val hanTra: Int,
    val soHieuSach: Int
) :
    SinhVien(hoTen, tuoi, lop)

class QuanLiThuVien() {
    val listTheMuon: ArrayList<TheMuon> = arrayListOf()
    fun ThemThongTinTheMuon(theMuon: TheMuon) {
        listTheMuon.add(theMuon)
    }

    fun XoaTheoMaPhieuMuon(maPhieuMuon: String): List<TheMuon> {
        for (i in 0 until listTheMuon.size) {
            if (listTheMuon[i].maPhieuMuon == maPhieuMuon) {
                listTheMuon.remove(listTheMuon[i])
            }
        }
        return listTheMuon
    }

    fun HienThiThongTinTheMuon() {
        for (i in 0 until listTheMuon.size) {
            println(
                "Ho Ten: ${listTheMuon[i].hoTen} ," +
                        "Tuoi: ${listTheMuon[i].tuoi} , " +
                        "Lop: ${listTheMuon[i].lop} , " +
                        "Ma Phieu Muon: ${listTheMuon[i].maPhieuMuon} ," +
                        "Ngay Muon: ${listTheMuon[i].ngayMuon} ," +
                        "Han Tra: ${listTheMuon[i].hanTra} ," +
                        "So Hieu Sach: ${listTheMuon[i].soHieuSach} ,"
            )
        }
    }

}

fun main() {
    val qltv: QuanLiThuVien = QuanLiThuVien()
    while (true) {
        println("Nhap 1: Them Thong Tin Dang Ki The Muon: ")
        println("Nhap 2: Xoa The Muon Theo Ma The Muon: ")
        println("Nhap 3: Hien Thi Thong Tin The Muon: ")
        val input = readLine()
        when (input) {
            "1" -> {
                println("Nhap Ho Ten: ")
                val hoTen = readLine() ?: ""
                println("Nhap Tuoi: ")
                val tuoi = readLine()?.toInt() ?: 0
                println("Nhap Lop: ")
                val lop = readLine() ?: ""
                println("Nhap Ma Phieu Muon: ")
                val maPhieuMuon = readLine() ?: ""
                println("Nhap Ngay Muon: ")
                val ngayMuon = readLine()?.toInt() ?: 0
                println("Nhap Han Tra: ")
                val hanTra = readLine()?.toInt() ?: 0
                println("Nhap So Hieu Sach: ")
                val soHieuSach = readLine()?.toInt() ?: 0
                val theMuon: TheMuon =
                    TheMuon(hoTen, tuoi, lop, maPhieuMuon, ngayMuon, hanTra, soHieuSach)
                qltv.ThemThongTinTheMuon(theMuon)
            }
            "2" -> {
                println("Nhap Ma Phieu Muon Can Xoa: ")
                val maPhieuMuon = readLine() ?: ""
                qltv.XoaTheoMaPhieuMuon(maPhieuMuon)
                val ketQua = qltv.XoaTheoMaPhieuMuon(maPhieuMuon)
                print("Ket Qua La: ")
                ketQua.forEach {
                    println("Ten: ${it.hoTen}")
                    println("Tuoi: ${it.tuoi}")
                }
            }
            "3" -> {
                qltv.HienThiThongTinTheMuon()
            }
        }
    }
}