new Vue({
    el: "#app",
    data: {
        rootUrl: 'http://localhost:8080/api',
        products: [],
        product: {
            id: '',
            name: '',
            description: '',
            rating: '',
            price: '',
            imageUrl: ''
        },
        isError: false
    },
    methods: {
        getProducts() {
            axios.get(this.rootUrl + '/products')
            .then((resp) => {
                console.log(resp.data);
                this.products = resp.data;
            })
            .catch((err) => {
                console.log(err);
            })
        },
        deleteProduct(id) {
            axios.delete(this.rootUrl + '/products/' + id)
            .then((resp) => {
                console.log(resp.data);
                this.products = this.getProducts();
            })
            .catch((err) => {
                console.log(err);
            })
        },
        saveProduct() {

            if (this.product.name === "") {
                this.isError = true;
                return;
            }

            axios.post(this.rootUrl + "/products/add", this.product)
            .then((resp) => {
                this.product = {};
                this.isError = false;
                this.products = this.getProducts();
            })
            .catch((err) => {
                console.log(err);
            })
        },
        getProduct(id) {
            axios.get(this.rootUrl + '/products/' + id)
            .then((resp) => {
                this.product = resp.data;
            })
            .catch((err) => {
                console.log(err);
            })
        }
    },
    mounted() {
        this.getProducts();
    }
})