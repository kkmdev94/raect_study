# logic/file_copier.py

import os
import shutil
import pandas as pd

def copy_pdf_with_excel_names(source_pdf_path, excel_path, column_name, dest_dir):
    try:
        if not os.path.exists(source_pdf_path):
            return {"error": "원본 PDF 파일이 존재하지 않습니다."}
        if not source_pdf_path.lower().endswith(".pdf"):
            return {"error": "원본 파일은 PDF여야 합니다."}

        df = pd.read_excel(excel_path)
        if column_name not in df.columns:
            return {"error": f"엑셀에 '{column_name}' 컬럼이 없습니다."}

        total = 0
        success = 0
        fail = 0

        for value in df[column_name].dropna():
            total += 1
            filename = str(value).strip() + ".pdf"
            dst = os.path.join(dest_dir, filename)

            try:
                shutil.copy2(source_pdf_path, dst)
                success += 1
            except Exception:
                fail += 1

        return {
            "success": success,
            "fail": fail,
            "total": total
        }

    except Exception as e:
        return {"error": str(e)}
