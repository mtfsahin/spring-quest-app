<template>
    <a :class="buttonClasses,borderClasses">
        <slot>Button Component</slot>
    </a>
</template>




<script>
export default {
    name:'Button',
    props:{
        type:{
            type:String,
            default:'primary',
            validator: (value) => {
                return ['primary', 'secondary', 'success', 'danger', 'info', 'warning'].includes(value);
            },
        bordertype: {
            type:String,
            default:'dashed',
            validator: (value) => {
                return ['dashed', 'solid'].includes(value);
            }
        }, 
        icon:{
            type:String,
            default:'none',
            validator: (value) => {
                return ['']
            }
        },
        
        }
    },
    computed:{
        buttonClasses(){
            return {
                'button-primary': this.type === 'primary',
                'button-secondary': this.type === 'secondary',
                'button-success': this.type === 'success',
                'button-danger': this.type === 'danger',
                'button-info': this.type === 'info',
                'button-warning': this.type === 'warning',
            }
        },
        borderClasses(){
            return {
                'border-dashed': this.bordertype === 'dashed',
                'border-solid': this.bordertype === 'solid'
            }
        }

    },

};
</script>

<style scoped>
a {
    display: flex;
    justify-content: center;
    padding: 10px;
    border-radius: 5px;

    cursor: pointer;
}

a:hover {
    transition: 0.3s;
    padding-left: 10px;
    padding-right: 10px;
    border-radius: 5px;
}

.button-primary {
    background-color: #A27B5C;
    border-style: dashed;
}

.button-primary:hover {
    background-color: #DCD7C9;
    border-style: dashed;
    color: #3F4E4F;

}

.button-secondary {
    background-color: #f7f7f7;
    border-style: solid;
    border-color: #f7f7f7;
    margin: 5px;
    
}

.button-secondary:hover {
    background-color: #DCD7C9;
    border-style: solid;
    color: #3F4E4F;
    margin: 5px;
}

.border-dashed {
    border-style: dashed;
}

.border-solid {
    
}

.border-none {

}

</style>