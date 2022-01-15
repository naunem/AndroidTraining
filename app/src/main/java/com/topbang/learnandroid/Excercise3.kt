package com.topbang.learnandroid

//Bài 3
//Các thí sinh dự thi đại học bao gồm các thí sinh thi khối A, B, và khối C.
// Các thí sinh cần quản lý các thông tin sau: Số báo danh, họ tên, địa chỉ, mức ưu tiên.
//
//Thí sinh thi khối A thi các môn: Toán, Lý, Hoá.
//
//Thí sinh thi khối B thi các môn: Toán, Hoá, Sinh.
//
//Thí sinh thi khối C thi các môn: Văn, Sử, Địa.
//
//Yêu cầu 1: Xây dựng các lớp để quản lý các thi sinh dự thi đại học.
//
//Yêu cầu 2: Xây dựng lớp TuyenSinh có các chức năng:
//
//Thêm mới thí sinh.
//Hiện thị thông tin của thí sinh và khối thi của thí sinh.
//Tìm kiếm theo số báo danh.
//Thoát khỏi chương trình.
//Source code tham khảo

open class ThiSinh(val soBaoDanh: Int, val hoTen: String, val diaChi: String, val mucUuTien: String)
class ThiSinhKhoiA(
    soBaoDanh: Int,
    hoTen: String,
    diaChi: String,
    mucUuTien: String,
    val toan: Int,
    val li: Int,
    val hoa: Int
) :
    ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien)

class ThiSinhKhoiB(
    soBaoDanh: Int,
    hoTen: String,
    diaChi: String,
    mucUuTien: String,
    val toan: Int,
    val hoa: Int,
    val sinh: Int
) :
    ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien)

class ThiSinhKhoiC(
    soBaoDanh: Int,
    hoTen: String,
    diaChi: String,
    mucUuTien: String,
    val van: Int,
    val su: Int,
    val dia: Int
) :
    ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien)

class TuyenSinh() {
    val listStudent: ArrayList<ThiSinh> = arrayListOf()
    fun addStudent(thiSinh: ThiSinh) {
        listStudent.add(thiSinh)
    }

    fun HienThiThongTinThiSinhVaKhoi() {
        for (i in 0 until listStudent.size) {
            println(
                "${listStudent[i].soBaoDanh}," +
                        "${listStudent[i].hoTen}," +
                        "${listStudent[i].diaChi}," +
                        "${listStudent[i].mucUuTien},"

            )

        }

    }

    fun timKiemThiSinhTheoSBD(soBaoDanh: Int): List<ThiSinh> {
        for (i in 0 until listStudent.size) {
            if (listStudent[i].soBaoDanh == soBaoDanh) {
                listStudent.add(listStudent[i])
            }
        }
        return listStudent
    }

}


fun main() {
    val ts: TuyenSinh = TuyenSinh()
    while (true) {
        println("Nhap 1: Them Moi Thi Sinh: ")
        println("Nhap 2: Hien Thi Thong Tin Thi Sinh: ")
        println("Nhap 3: Tim Kiem Thi Sinh Theo SBD: ")
        println("Nhap 4: Thoat Khoi Chuong Trinh: ")
        val input = readLine()
        when (input) {
            "1" -> {
                println("Nhap Ten Thi Sinh")
                val ten = readLine() ?: ""
                println("Nhap SO Bao Danh: ")
                val sBD = readLine()?.toInt() ?: 0
                println("Nhap Dia Chi Thi SInh")
                val diaChi = readLine() ?: ""
                println("Nhap Muc Uu Tien: ")
                val mucUuTien = readLine() ?: ""
                println("Nhap Khoi: ")
                val khoi = readLine()
                when (khoi) {
                    "A", "a" -> {
                        println("Nhap Diem Toan: ")
                        val diemToan = readLine()?.toInt() ?: 0
                        println("Nhap Diem Ly: ")
                        val diemLy = readLine()?.toInt() ?: 0
                        println("Nhap Diem Hoa: ")
                        val diemHoa = readLine()?.toInt() ?: 0
                        ts.addStudent(
                            ThiSinhKhoiA(
                                soBaoDanh = sBD,
                                ten,
                                diaChi,
                                mucUuTien,
                                diemLy,
                                diemToan,
                                diemHoa
                            )
                        )
                    }
                    "B", "b" -> {
                        println("Nhap Diem Toan: ")
                        val diemToan = readLine()?.toInt() ?: 0
                        println("Nhap Diem Hoa: ")
                        val diemHoa = readLine()?.toInt() ?: 0
                        println("Nhap Diem Sinh: ")
                        val diemSinh = readLine()?.toInt() ?: 0
                        ts.addStudent(
                            ThiSinhKhoiB(
                                soBaoDanh = sBD,
                                hoTen = ten,
                                diaChi = diaChi,
                                mucUuTien = mucUuTien,
                                toan = diemToan,
                                hoa = diemHoa,
                                sinh = diemSinh
                            )
                        )
                    }
                    "C", "c" -> {
                        println("Nhap Diem Van: ")
                        val diemVan = readLine()?.toInt() ?: 0
                        println("Nhap Diem Su: ")
                        val diemSu = readLine()?.toInt() ?: 0
                        println("Nhap Diem Dia: ")
                        val diemDia = readLine()?.toInt() ?: 0
                        ts.addStudent(
                            ThiSinhKhoiC(
                                soBaoDanh = sBD,
                                hoTen = ten,
                                diaChi = diaChi,
                                mucUuTien = mucUuTien,
                                van = diemVan,
                                su = diemSu,
                                dia = diemDia
                            )
                        )
                    }
                }
            }
            "2" -> {
                ts.HienThiThongTinThiSinhVaKhoi()

            }
            "3" -> {
                println("Nhap So Bao Danh Can Tim Kiem: ")
                val soBaoDanh = readLine()?.toInt() ?: 0
                ts.timKiemThiSinhTheoSBD(soBaoDanh)
                val ketQua = ts.timKiemThiSinhTheoSBD(soBaoDanh)
                print("Ket Qua La: ")
                ketQua.forEach {
                    println("SBD: ${it.soBaoDanh}")
                    println("Ten: ${it.hoTen}")
                    println("Dia Chi: ${it.diaChi}")
                    println("Muc Uu Tien: ${it.mucUuTien}")

                }
            }
        }
    }
}