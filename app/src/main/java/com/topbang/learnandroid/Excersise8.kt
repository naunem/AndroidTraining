package com.topbang.learnandroid

import android.icu.text.RelativeDateTimeFormatter

//Khoa CNTT – DHKHTN cần quản lý việc thanh toán tiền lương cho các cán bộ giáo viên trong khoa.
// Để quản lý được, khoa cần các thông tin sau:
//Với mỗi cán bộ giáo viên có các thông tin sau:
// lương cứng, lương thưởng, tiền phạt, lương thực lĩnh, và các thông tin cá nhân:
// Họ tên, tuổi, quê quán, mã số giáo viên.
//Yêu cầu 1: Xây dựng lớp Nguoi để quản lý các thông tin cá nhân của mỗi giáo viên.
//Yêu cầu 2: Xây dựng lớp CBGV để quản lý các thông tin của các cán bộ giáo viên.
//Yêu cầu 3: Xây dựng các phương thức thêm, xoá các cán bộ giáo viên theo mã số giáo viên.
//Yêu cầu 4: Tính lương thực lĩnh cho giáo viên: Lương thực = Lương cứng + lương thưởng – lương phạt.

open class Nguoi(val hoTen: String, val tuoi: Int, val queQuan: String, val maSoGV: String)
class CBGV(
    hoTen: String,
    tuoi: Int,
    queQuan: String,
    maSoGV: String,
    val luongCung: Int,
    val luongThuong: Int,
    val tienPhat: Int
) :
    Nguoi(hoTen, tuoi, queQuan, maSoGV) {
    var luongThucLinh: Int = 0
}

class QuanLiCanBoGV() {
    val listCBGV: ArrayList<Nguoi> = arrayListOf()
    fun themCBGV(nguoi: Nguoi) {
        listCBGV.add(nguoi)
    }

    fun xoaCBGVTheoMaSoGV(maSoGV: String): List<Nguoi> {
        for (i in 0 until listCBGV.size) {
            if (listCBGV[i].maSoGV == maSoGV) {
                listCBGV.remove(listCBGV[i])
            }
        }
        return listCBGV
    }

    fun HienThiThongTinCBGV() {
        for (i in 0 until listCBGV.size) {
            println(
                "Ho Ten GV: ${listCBGV[i].hoTen}," +
                        "\nTuoi GV: ${listCBGV[i].tuoi}," +
                        "\nQue Quan GV: ${listCBGV[i].queQuan}," +
                        "\nMa So GV: ${listCBGV[i].maSoGV},"
            )
        }
    }

    fun tinhTienLuong(maSoGV: String): Int {
        listCBGV.forEach {
            if (it.maSoGV == maSoGV) {
                val giaoVien: CBGV = it as CBGV
                giaoVien.luongThucLinh =
                    giaoVien.luongCung + giaoVien.luongThuong - giaoVien.tienPhat
                return giaoVien.luongThucLinh
            }
        }
        return 0
    }
}


fun main() {
    val qlcbgv: QuanLiCanBoGV = QuanLiCanBoGV()
    while (true) {
        println("Nhap 1: Them Moi CBGV: ")
        println("Nhap 2: Xoa CBGV Theo Ma So GV: ")
        println("Nhap 3: Hien Thi Thong Tin Cac GV: ")
        println("Nhap 4: Tinh Luong Thuc Linh Cua GV: ")

        val input = readLine()
        when (input) {
            "1" -> {
                println("Nhap Ten GV: ")
                val hoTen = readLine() ?: ""
                println("Nhap Tuoi GV: ")
                val tuoi = readLine()?.toInt() ?: 0
                println("Nhap Que Quan GV: ")
                val queQuan = readLine() ?: ""
                println("Nhap Ma So GV: ")
                val maSoGV = readLine() ?: ""
                println("Nhap So Tien Luong Cung: ")
                val luongCung = readLine()?.toInt() ?: 0
                println("Nhap So Tien Luong Thuong: ")
                val luongThuong = readLine()?.toInt() ?: 0
                println("Nhap So TienPhat: ")
                val tienPhat = readLine()?.toInt() ?: 0
                val gv: CBGV = CBGV(hoTen, tuoi, queQuan, maSoGV, luongCung, luongThuong, tienPhat)
                qlcbgv.themCBGV(gv)

            }
            "2" -> {
                println("Nhap Ma So GV Can Xoa: ")
                val maSoGV = readLine() ?: ""
                val ketQua = qlcbgv.xoaCBGVTheoMaSoGV(maSoGV)
                print("Ket Qua La: ")
                ketQua.forEach {
                    println("SBD: ${it.hoTen}")
                    println("Ten: ${it.tuoi}")
                    println("Dia Chi: ${it.queQuan}")
                    println("Muc Uu Tien: ${it.maSoGV}")
                }
            }
            "3" -> {
                qlcbgv.HienThiThongTinCBGV()
            }
            "4" -> {
                println("Nhap Ma Giao Vien Can Tinh Luong: ")
                val maSoGV = readLine() ?: ""
                val luongThucLinh = qlcbgv.tinhTienLuong(maSoGV)
                println("Luong Thuc Linh La: $luongThucLinh ")
            }
        }
    }
}
