import os


def rename_files():
    for i in range(1, 35):
        old_name = f"UC{i}.pdf"
        new_name = f"SPEC{i}.pdf"
        try:
            os.rename(old_name, new_name)
            print(f"File '{old_name}' renamed to '{new_name}' successfully.")
        except FileNotFoundError:
            print(f"Error: File '{old_name}' not found.")
        except Exception as e:
            print(f"An error occurred: {e}")


rename_files()
