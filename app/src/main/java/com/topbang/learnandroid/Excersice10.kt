package com.topbang.learnandroid

import android.widget.ArrayAdapter

//Để quản lý biên lai thu tiền điện, người ta cần các thông tin sau:
//Với mỗi biên lai: Thông tin về hộ sử dụng điện, chỉ số điện cũ, chỉ số mới, số tiền phải trả.
//Các thông tin riêng của từng hộ gia đình sử dụng điện: Họ tên chủ hộ, số nhà, mã số công tơ điện.
//Yêu cầu 1: Hãy xây dựng lớp khachHang để lưu trữ các thông tin riêng của mỗi hộ gia đình.
//Yêu cầu 2: Xây dựng lớp BienLai để quản lý việc sử dụng và thanh toán tiền điện của các hộ dân.
//Yêu cầu 3: Xây dựng các phương thức thêm, xoá các thông tin riêng của mỗi hộ sử dụng điện.
//Yêu cầu 4: Viết phương thức tính tiền điện cho mỗi hộ gia đình theo công thức: (số mới – số cũ ) * 5.
open class KhachHang(val hoTenChuHo: String, val soNha: Int, val maSoCongToDien: String)
class BienLai(
    hoTenChuHo: String,
    soNha: Int,
    maSoCongToDien: String,
    val chiSoDienCu: Int,
    val chiSoMoi: Int,
    val soTienPhaiTra: Int
) :
    KhachHang(hoTenChuHo, soNha, maSoCongToDien)

class QuanLyBienLaiThuTienDien() {
    val listBienLai: ArrayList<BienLai> = arrayListOf()
    fun ThemThongTinHoDan(bienLai: BienLai) {
        listBienLai.add(bienLai)
    }

    fun XoaThongTinHoDan() {

    }
}

fun main() {
    val qlbl: QuanLyBienLaiThuTienDien = QuanLyBienLaiThuTienDien()
    while (true) {
        println("Nhap 1: Them Thong Tin Ho Dan: ")
        println("Nhap 2: Xoa Thong Tin Ho Dan: ")
        val input = readLine()
        when (input) {
            "1" -> {
                println("Nhap Ho Ten Chu Ho: ")
                val hoTenChuHo = readLine() ?: ""
                println("Nhap So Nha: ")
                val soNha = readLine()?.toInt() ?: 0
                println("Nhap Ma So Cong To Dien: ")
                val maSoCongToDien = readLine() ?: ""
                println("Nhap Chi So Cu: ")
                val chiSoDienCu = readLine()?.toInt() ?: 0
                println("Nhap Chi So Moi: ")
                val chiSoMoi = readLine()?.toInt() ?: 0
                println("Nhap So Tien Phai Tra: ")
                val soTienPhaiTra = readLine()?.toInt() ?: 0
                val bienLai: BienLai =
                    BienLai(hoTenChuHo, soNha, maSoCongToDien, chiSoDienCu, chiSoMoi, soTienPhaiTra)
                qlbl.ThemThongTinHoDan(bienLai)
            }
            "2" -> {
                qlbl.XoaThongTinHoDan()
            }
        }
    }
}