import unittest
import tempfile
import shutil
import os
import pandas as pd
from file_copier import copy_files_from_execl

class TestFileCopier(unittest.TestCase):
    def setUp(self):
        self.test_dir = tempfile.mkdtemp()
        self.original_file_path = os.path.join(self.test_dir, "original_file.pdf")
        with open(self.original_file_path, "w") as f:
            f.write("Original file content")

        self.excel_file = os.path.join(self.test_dir, "test.xlsx")
        df = pd.DataFrame({'number ' : ['A1', 'A2', 'A3']})
        df.to_excel(self.excel_file, index=False)

        self.output_directory = os.path.join(self.test_dir, "output")
        os.makedirs(self.output_directory, exist_ok=True)

    def test_file_copy(self):
        copied_count = copy_files_from_execl(
            self.original_file_path, self.excel_file, self.output_directory, "number "
        )
        self.assertEqual(copied_count, 3)

        for code in ['A1', 'A2', 'A3']:
            path = os.path.join(self.output_directory, f"{code}.pdf")
            self.assertTrue(os.path.exists(path))
            with open(path, "r") as f:
                self.assertEqual(f.read(), "Original file content")

    def tearDown(self):
        shutil.rmtree(self.test_dir)

if __name__ == "__main__":
    unittest.main(verbosity=2)