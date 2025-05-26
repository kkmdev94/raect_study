# main.py

import tkinter as tk
from tkinter import filedialog, messagebox
from file_copier import copy_pdf_with_excel_names


class FileCopierApp:
    def __init__(self, root):
        self.root = root
        self.root.title("엑셀 기반 파일 복사기")

        self.source_pdf = tk.StringVar()
        self.excel_path = tk.StringVar()
        self.dest_dir = tk.StringVar()
        self.column_name = tk.StringVar()

        self.setup_gui()

    def setup_gui(self):
        # 원본 폴더
        self.add_path_row("원본 PDF 파일", self.source_pdf, self.select_pdf_file)

        # 엑셀 파일
        self.add_path_row("엑셀 파일", self.excel_path, self.select_excel_file)

        # 복사 위치
        self.add_path_row("복사 위치", self.dest_dir, self.select_dest_dir)

        # 엑셀 컬럼명
        tk.Label(self.root, text="엑셀 컬럼명:").grid(row=3, column=0, sticky="e", padx=5, pady=5)
        tk.Entry(self.root, textvariable=self.column_name, width=40).grid(row=3, column=1, padx=5, pady=5, sticky="w")

        # 작업 시작 버튼
        tk.Button(self.root, text="작업 시작", command=self.start_copy, width=20, bg="lightblue").grid(row=4, column=0, columnspan=3, pady=15)

    def add_path_row(self, label, var, command):
        row = len(self.root.grid_slaves()) // 3
        tk.Label(self.root, text=label + ":", anchor="e").grid(row=row, column=0, padx=5, pady=5, sticky="e")
        tk.Entry(self.root, textvariable=var, width=40).grid(row=row, column=1, padx=5, pady=5)
        tk.Button(self.root, text="찾기", command=command).grid(row=row, column=2, padx=5, pady=5)

    def select_pdf_file(self):
        path = filedialog.askopenfilename(filetypes=[("PDF files", "*.pdf")])
        if path:
            self.source_pdf.set(path)

    def select_excel_file(self):
        path = filedialog.askopenfilename(filetypes=[("Excel files", "*.xlsx *.xls")])
        if path:
            self.excel_path.set(path)

    def select_dest_dir(self):
        path = filedialog.askdirectory(title="복사 위치 선택")
        if path:
            self.dest_dir.set(path)

    def start_copy(self):
        if not all([self.source_pdf.get(), self.excel_path.get(), self.dest_dir.get(), self.column_name.get()]):
            messagebox.showwarning("입력 오류", "모든 항목을 입력/선택해주세요.")
            return

        result = copy_pdf_with_excel_names(
            self.source_pdf.get(),
            self.excel_path.get(),
            self.column_name.get(),
            self.dest_dir.get()
        )

        if "error" in result:
            messagebox.showerror("오류 발생", result["error"])
        else:
            msg = (
                f"복사 완료!\n\n"
                f"성공: {result['success']}개\n"
                f"실패: {result['fail']}개\n"
                f"총 시도: {result['total']}개"
            )
            messagebox.showinfo("작업 결과", msg)

if __name__ == "__main__":
    root = tk.Tk()
    app = FileCopierApp(root)
    root.mainloop()
