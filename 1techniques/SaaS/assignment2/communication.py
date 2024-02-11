import requests
from pprint import pprint

#product endpoints
def get_all_products():
    return requests.get('http://127.0.0.1:5000/products').json()

def get_product(prod_id):
    return requests.get(f'http://127.0.0.1:5000/products/{prod_id}').json()

def create_product(name, price, quantity):
    new_prod = {"name" : name, "price" : price, "quantity" : quantity}
    return requests.post('http://127.0.0.1:5000/products', json = new_prod).json()

def update_product(product_id, quantity):
    return requests.post(f'http://127.0.0.1:5000/products/update/{product_id}', 
                         json = {"quantity" : quantity})


#cart endpoints
def get_the_cart(user_id):
    return requests.get(f'http://127.0.0.1:5001/cart/{user_id}').json()

def add_to_cart(user_id, product_id, quantity):
    return requests.post(f'http://127.0.0.1:5001/cart/{user_id}/add/{product_id}', 
                         json = {"quantity" : quantity}).json()
    
def remove_from_cart(user_id, product_id, quantity):
    return requests.post(f'http://127.0.0.1:5001/cart/{user_id}/remove/{product_id}',
                         json = {"quantity" : quantity}).json()



if __name__ == '__main__':
    
    # ### product endpoint tests
    # created_prod = create_product("iphone", 1500.99, 3)
    # print(f"\n\nCreated product: {created_prod}")
    
    # specific_prod = get_product(1)
    # print(f"\n\nSpecific product: {specific_prod}")
    
    update_prod = update_product(1, 5)
    if update_prod.status_code == 200:
        print(f"\n\nUpdate product: {update_prod}")
    
    all_prods = get_all_products()
    print(f"\n\nAll products {all_prods}") 
    
    
     
     
    
    
    # ### cart endpoint test
    # get_cart_res = get_the_cart(1)
    # print(f"\n\nGet cart result: {get_cart_res}")
    
    # add_cart_res = add_to_cart(1, 1, 5)
    # print(f"\n\nAdd cart result: {add_cart_res}")
    
    # get_cart_res2 = get_the_cart(1)
    # print(f"\n\nGet cart result2: {get_cart_res}")
    
    # rem_cart_res = remove_from_cart(1, 1, 10)
    # print(f"\n\nRem cart result: {rem_cart_res}")
    
    # get_cart_res3 = get_the_cart(1)
    # print(f"\n\nGet cart result3: {get_cart_res}")