package com.topbang.learnandroid
//Để quản lý hồ sơ học sinh của trường THPT nhà trường cần các thông tin sau:
// Lớp,  và các thông tin về cá nhân của mỗi học sinh.
//
//Mỗi học sinh có các thông tin sau: Họ tên, tuổi, quê quán.
//
//Yêu cầu 1: Xây dựng HocSinh để quản lý thông tin của mỗi học sinh.
//
//Yêu cầu 2: Xây dựng các phương thức thêm, hiển thị thông tin của mỗi học sinh.
//
//Yêu cầu 3: Cài đặt chương trình có các chức năng sau:
//
//Thêm học sinh mới.
//Hiện thị các học sinh 20 tuổi.
//Cho biết số lượng các học sinh có tuổi là 23 và quê ở DN.

class HocSinh(val lop: String, val hoTen: String, val tuoi: Int, val queQuan: String)
class QuanLiHocSinh() {
    val listHocSinh: ArrayList<HocSinh> = arrayListOf()
    fun ThemMoiHocSinh(hocSinh: HocSinh) {
        listHocSinh.add(hocSinh)
    }

    fun HienThiThongTinHocSinh() {
        for (i in 0 until listHocSinh.size) {
            println(
                "Lop: ${listHocSinh[i].lop}," +
                        "Ho Ten: ${listHocSinh[i].hoTen}," +
                        "Tuoi: ${listHocSinh[i].tuoi}," +
                        "Que Quan: ${listHocSinh[i].queQuan},"
            )
        }
    }
    fun HienThiHocSinhtren20T(){

    }
}


fun main() {
    val qlhs: QuanLiHocSinh = QuanLiHocSinh()
    while (true) {
        println("Nhap 1: Them Moi Hoc Sinh: ")
        println("Nhap 2: Hien Thi Thong Tin Thi Sinh: ")
        val input = readLine()
        when (input) {
            "1" -> {
                println("Nhap Lop: ")
                val lop = readLine() ?: ""
                println("Nhap Ho Ten: ")
                val hoTen = readLine() ?: ""
                println("Nhap Tuoi: ")
                val tuoi = readLine()?.toInt() ?: 0
                println("Nhap Que Quan: ")
                val queQuan = readLine() ?: ""
                val hocSinh: HocSinh = HocSinh(lop, hoTen, tuoi, queQuan)
                qlhs.ThemMoiHocSinh(hocSinh)
            }
            "2" -> {
                qlhs.HienThiThongTinHocSinh()
            }
            else -> {
                println("Nhap Sai, Vui Long Nhap Lai: ")
            }
        }

    }
}