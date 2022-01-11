package com.topbang.learnandroid

//Bài 1
//Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên. Mỗi cán bộ cần quản lý các dữ liệu:
// Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
//
//Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
//Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
//Các nhân viên có thuộc tính riêng: công việc.
//Yêu cầu 1: Xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp CanBo.
//
//Yêu cầu 2: Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng sau:
//
//Thêm mới cán bộ.
//Tìm kiếm theo họ tên.
//Hiện thị thông tin về danh sách các cán bộ.
//Thoát khỏi chương trình.

open class CanBo(val hoTen: String, val tuoi: Int, val gioiTinh: String, val diaChi: String)
class CongNhan(val bac: Int, hoTen: String, tuoi: Int, gioiTinh: String, diaChi: String) :
    CanBo(hoTen, tuoi, gioiTinh, diaChi)

class KySu(val nganhDaoTao: String, hoTen: String, tuoi: Int, gioiTinh: String, diaChi: String) :
    CanBo(hoTen, tuoi, gioiTinh, diaChi)

class NhanVien(val congViec: String, hoTen: String, tuoi: Int, gioiTinh: String, diaChi: String) :
    CanBo(hoTen, tuoi, gioiTinh, diaChi)

class QlCB {
    private val listCanBo: ArrayList<CanBo> = arrayListOf()
    fun themCanBo(canBo: CanBo) {
        listCanBo.add(canBo)
    }

    fun timKiemCanBoTheoTen(name: String): List<CanBo> {
        val list: ArrayList<CanBo> = arrayListOf()
        for (i in 0 until listCanBo.size) {
            if (listCanBo[i].hoTen == name) {
                list.add(listCanBo[i])
            }
        }
        return list
    }

    fun hienThiThongTinCanBo() {
        for (i in 0 until listCanBo.size) {
            println(
                listCanBo[i].hoTen
                        + listCanBo[i].tuoi
                        + listCanBo[i].gioiTinh
                        + listCanBo[i].diaChi

            )
        }
    }
}


fun main() {
    val qlcb: QlCB = QlCB()
    while (true) {
        println("Nhap 1: Them Moi Can Bo: ")
        println("Nhap 2: Tim Kiem Can Bo Theo Ten: ")
        println("Nhap 3: Hien Thi Thong Tin Can Bo: ")
        println("Nhap 4: Nhap Sai Cu Phap: ")
        val input = readLine()
        when (input) {
            "1" -> {
                println("Nhap Ten: ")
                val ten = readLine() ?: ""
                println("Nhap Tuoi: ")
                val tuoi = readLine()?.toInt() ?: 0
                println("Nhap Gioi Tinh: ")
                val gioiTinh = readLine() ?: ""
                println("Nhap Dia Chi: ")
                val diaChi = readLine() ?: ""
                val canBo: CanBo = CanBo(ten, tuoi, gioiTinh, diaChi)
                qlcb.themCanBo(canBo)
            }
            "2" -> {
                println("Nhap Ten Can Bo Can Tim Kiem: ")
                val ten = readLine() ?: ""
                qlcb.timKiemCanBoTheoTen(ten)
                val ketQua = qlcb.timKiemCanBoTheoTen(ten)
                println("Ket Qua Tim Kiem La: ")
                ketQua.forEach {
                    println("${it.hoTen},${it.tuoi} ,${it.gioiTinh},${it.diaChi}")
                }
            }
            "3" -> {
                qlcb.hienThiThongTinCanBo()
            }
            "4" -> {
                return
            }

            else -> {
                print("Nhap Sai, Vui Long Nhap Lai: ")
            }
        }

    }
}
