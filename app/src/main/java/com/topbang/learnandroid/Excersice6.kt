package com.topbang.learnandroid

//Bài 4
//Để quản lý các hộ dân cư trong một khu phố, người ta cần các thông tin sau:
// Số thành viên trong gia đình, Số nhà, thông tin mỗi cá nhân trong gia đình.
// Với mỗi cá nhân, người ta quản lý các thông tin sau:
// Họ tên, Tuổi, Nghề nghiệp, số chứng minh nhân dân(duy nhất cho mỗi người).
//
//Yêu cầu 1: Hãy xây dựng lớp Nguoi để quản lý thông tin của mỗi cá nhân.
//Yêu cầu 2: Xây dựng lớp HoGiaDinh để quản lý thông tin của từng hộ gia đình.
//
//Yêu cầu 2: Xây dựng lớp KhuPho để quản lý các thông tin của từng hộ gia đình.
//
//Yêu cầu 3: Nhập n hộ dân. (n nhập từ bàn phím), hiển thị thông tin của các hộ trong khu phố.

open class Nguoi1(val hoTen: String, val tuoi: Int, val ngheNghiep: String, val soCMND: Int)
open class HoGiaDinh(
    val soThanhVien: Int,
    val soNha: Int,
    hoTen: String,
    tuoi: Int,
    ngheNghiep: String,
    soCMND: Int
) :
    Nguoi1(hoTen, tuoi, ngheNghiep, soCMND)

class KhuPho(
    soThanhVien: Int,
    soNha: Int,
    hoTen: String,
    tuoi: Int,
    ngheNghiep: String,
    soCMND: Int
)

class QuanLiHoDanCu() {
    val listHoGiaDinh: ArrayList<HoGiaDinh> = arrayListOf()
    fun ThemThongTinHoDanCu(hoGiaDinh: HoGiaDinh) {
        listHoGiaDinh.add(hoGiaDinh)
    }

    fun HienThiThongTinHoDanCu() {
        for (i in 0 until listHoGiaDinh.size) {
            println(
                "So Nha: ${listHoGiaDinh[i].soNha}," +
                        "So Thanh Vien: ${listHoGiaDinh[i].soThanhVien}," +
                        "Ho Ten: ${listHoGiaDinh[i].hoTen}," +
                        "Tuoi: ${listHoGiaDinh[i].tuoi}," +
                        "Nghe Nghiep: ${listHoGiaDinh[i].ngheNghiep}," +
                        "So CMND: ${listHoGiaDinh[i].soCMND}"

            )
        }
    }
}

fun main() {
    val qlhdc: QuanLiHoDanCu = QuanLiHoDanCu()
    while (true) {
        println("Nhap 1: De Them Thong Tin Ho Dan Cu: ")
        println("Nhap 2: Hien Thi Thong Tin Ho Dan Cu: ")
        val input = readLine()
        when (input) {
            "1" -> {
                println("Nhap So Nha: ")
                val soNha = readLine()?.toInt() ?: 0
                println("Nhap So Thanh Vien: ")
                val soThanhVien = readLine()?.toInt() ?: 0
                println("Nhap Ho Ten Thanh Vien: ")
                val hoTen = readLine() ?: ""
                println("Nhap Tuoi Thanh Vien: ")
                val tuoi = readLine()?.toInt() ?: 0
                println("Nhap Nghe Nghiep Thanh Vien: ")
                val ngheNghiep = readLine() ?: ""
                println("Nhap So CMND Thanh Vien: ")
                val soCMND = readLine()?.toInt() ?: 0
                val hoDanCu: HoGiaDinh = HoGiaDinh(soThanhVien, soNha, hoTen, tuoi, ngheNghiep, soCMND)
                qlhdc.ThemThongTinHoDanCu(hoDanCu)
            }
            "2" -> {
                qlhdc.HienThiThongTinHoDanCu()
            }
        }
    }
}
