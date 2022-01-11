package com.topbang.learnandroid

//Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi tài liệu gồm có các thuộc tính sau:
// Mã tài liệu(Mã tài liệu là duy nhất), Tên nhà xuất bản, số bản phát hành.
//
//Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
//
//Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
//
//Các báo cần quản lý thêm: Ngày phát hành.
//
//Yêu cầu 1: Xây dựng các lớp để quản lý tài liệu cho thư viện một cách hiệu quả.
//
//Yêu cầu 2: Xây dựng lớp QuanLySach có các chức năng sau
//
//Thêm mới tài liêu: Sách, tạp chí, báo.
//Xoá tài liệu theo mã tài liệu.
//Hiện thị thông tin về tài liệu.
//Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
//Thoát khỏi chương trình.


open class TaiLieu(val maTL: String, val tenNSB: String, val soBPM: Int)
class Sach(maTL: String, tenNSB: String, soBPM: Int, val tenTG: String, val soTrang: Int) :
    TaiLieu(maTL, tenNSB, soBPM)

class TapChi(maTL: String, tenNSB: String, soBPM: Int, val soPH: Int, val thangPH: Int) :
    TaiLieu(maTL, tenNSB, soBPM)

class Bao(maTL: String, tenNSB: String, soBPM: Int, val ngayPH: Int) :
    TaiLieu(maTL, tenNSB, soBPM)

class QuanLySach() {
    private val listTaiLieu: ArrayList<TaiLieu> = arrayListOf()
    private val listsach: ArrayList<Sach> = arrayListOf()
    private val listTapChi: ArrayList<TapChi> = arrayListOf()
    private val listBao: ArrayList<Bao> = arrayListOf()
    fun ThemTaiLieu(taiLieu: TaiLieu) {
        listTaiLieu.add(taiLieu)
    }

    fun XoaTaiLieuTheoSoTaiLieu() {

    }

    fun HienThiThongTinTaiLieu() {
        for (i in 0 until listTaiLieu.size) {
            when (listTaiLieu[i]) {
                is Sach -> {
                    val Sach = listTaiLieu[i] as Sach
                    println("${Sach.soTrang},${Sach.tenTG},${Sach.maTL},${Sach.tenNSB},${Sach.soBPM}")
                }
                is TapChi -> {
                    val tapChi = listTaiLieu[i] as TapChi
                    println("${tapChi.soPH},${tapChi.thangPH},${tapChi.maTL},${tapChi.tenNSB},${tapChi.soBPM}")
                }
                else -> {
                    val bao = listBao[i] as Bao
                    println("${bao.ngayPH},${bao.maTL},${bao.tenNSB},${bao.soBPM}")
                }
            }
        }
    }

    fun TimKiemTaiLieuTheoLoai(loai: String) {
        val list: ArrayList<Sach> = arrayListOf()
        for (i in 0 until listsach.size) {
            if (listsach[i].tenTG == loai)
                list.add(listsach[i])
        }
        return
    }
}


fun main() {
    val qls: QuanLySach = QuanLySach()
    while (true) {
        println("Nhap 1: Them Moi Tai Lieu")
        println("Nhap 2: Xoa Tai Lieu Theo Tai Lieu")
        println("Nhap 3: Hien Thi Tai Lieu")
        println("Nhap 4: Tim Kiem Tai Lieu Theo Loai: Sach , Bao , Tap Chi.")
        println("Nhap 5: Thoat Khoi Chuong Trinh")
        val input = readLine()
        when (input) {
            "1" -> {
                println("Them Moi Tai Lieu: ")
                println("Nhap a De Them Sach: ")
                println("Nhap b De Them Tap Chi: ")
                println("Nhap c De Them Bao: ")
                val nhap = readLine()
                when (nhap) {
                    "a", "A" -> {
                        println("Nhap Ten Tac Gia: ")
                        val tenTG = readLine() ?: ""
                        println("Nhap So Trang: ")
                        val soTrang = readLine() ?: ""
                        println("Nhap Ma Tai Lieu: ")
                        val maTL = readLine()?.toInt() ?: 0
                        println("Nhap Ten Nha Phat Minh: ")
                        val tenNPM = readLine() ?: ""
                        println("Nhap So Ban Phat Minh: ")
                        val soBPM = readLine()?.toInt() ?: 0
                        val sach: Sach = Sach(tenTG, soTrang, maTL, tenNPM, soBPM)
                        qls.ThemTaiLieu(sach)
                    }
                    "b","B" -> {
                        println("Nhap So Phat Hanh: ")
                        val soPH = readLine() ?: ""
                        println("Nhap So Thang Phat Hanh: ")
                        val soTPH = readLine() ?: ""
                        println("Nhap Ma Tai Lieu: ")
                        val maTL = readLine()?.toInt() ?: 0
                        println("Nhap Ten Nha Phat Minh: ")
                        val tenNPM = readLine()?.toInt()?:0
                        println("Nhap So Ban Phat Minh: ")
                        val soBPM = readLine()?.toInt() ?: 0
                        val tapChi: TapChi = TapChi(soPH, soTPH, maTL, tenNPM, soBPM)
                        qls.ThemTaiLieu(tapChi)
                    }
                    "c","C" -> {
                        println("Nhap Ngay Phat Hanh: ")
                        val ngayPH = readLine() ?: ""
                        println("Nhap Ma Tai Lieu: ")
                        val maTL = readLine()?: ""
                        println("Nhap Ten Nha Phat Minh: ")
                        val tenNPM = readLine()?.toInt() ?: 0
                        println("Nhap So Ban Phat Minh: ")
                        val soBPM = readLine()?.toInt() ?: 0
                        val bao: Bao = Bao(ngayPH, maTL, tenNPM, soBPM)
                        qls.ThemTaiLieu(bao)
                    }
                    else -> {
                        println("Nhap Sai")
                    }
                }
            }
            "2" -> {
                println("Nhap Ma Tai Lieu Can Xoa: ")
            }
        }

    }
}